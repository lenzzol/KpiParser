package controllers

import javax.inject._
import javax.management.Query

import scala.collection.JavaConversions._
import models._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def kpi(id: Int) =  Action {
    var result = "select ("
    var metricSchemeList = play.db.jpa.JPA.em("default")
      .createNamedQuery("MetricSchemeEntity.findByKpiStrategyOrdered")
      .setParameter("kpiStrategyId", id) // find metric scheme by kpi strategy id
      .getResultList()
      .asInstanceOf[java.util.ArrayList[MetricSchemeEntity]]

    for ((metricScheme, index) <- metricSchemeList.zipWithIndex){
      val metric = metricScheme.getMetricByMetricId() // get metric in metric scheme
      var defaultValue = if (metric.getDataTypeByResultDataTypeId().getIsNumeric().toInt == 1)
        metric.getDefaultResultValue.toFloat else metric.getDefaultResultValue
      var metricStatement = "("
      val orderedMetricFormulaSchemes = metric.getMetricFormulaSchemesByMetricId().toSeq.sortBy(mfsOrder => mfsOrder.getFormulaOrder) //get metric formulas schemes per metric sorted by order field
      val containsConditional = orderedMetricFormulaSchemes.exists(mfs => mfs.getMetricFormulaByMetricFormulaId.getFormulaOperationsByMetricFormulaId
        .toSeq.exists(formOp => formOp.getOperatorByOperatorId().getOperatorType() == "Conditional"))
      metricStatement += (if (containsConditional) "CASE WHEN " else "")
      for ((mfs, index) <- orderedMetricFormulaSchemes.zipWithIndex){ // go through each metric formula scheme to get metric formulas that makeup the metric
      val formulaOperations =
        mfs.getMetricFormulaByMetricFormulaId()
          .getFormulaOperationsByMetricFormulaId()
          .toSeq.sortBy(formOpOrder => formOpOrder.getOperationOrder)  // get all sorted formula operations for a given metric formula
      var metricFormulaStatement = "("
        formulaOperations.foreach(formOp => {
          val operator = if (formOp.getOperatorByOperatorId().getOperatorType() == "None") "" else formOp.getOperatorByOperatorId().getSymbol()
          val operandEntity = formOp.getOperandByOperandId
          val operandValue = translateDataType(operandEntity.getOperandValue, operandEntity.getDataTypeByOperandDataTypeId)
          val operand = if (operandValue == null && formOp.getOperandByOperandId.getDataFieldByOperandDataFieldId != null)
            formOp.getOperandByOperandId().getDataFieldByOperandDataFieldId().getDataFieldName() else operandValue
          val subStatement = operator.concat(s" $operand ")
          metricFormulaStatement += subStatement
        })
        metricFormulaStatement += ")"
        if (index == orderedMetricFormulaSchemes.length - 1){
          metricFormulaStatement = if (containsConditional) s" THEN $metricFormulaStatement ELSE $defaultValue END" else metricFormulaStatement
        }
        metricStatement += metricFormulaStatement
      }
      val operator = if (metricScheme.getOperatorByOperatorId().getOperatorType() == "None") "" else metricScheme.getOperatorByOperatorId().getSymbol()
      metricStatement = s" ${operator} ${metricStatement})"
      result += metricStatement
    }
    result += ")"
    Ok(result)
  }

  def translateDataType(dataValue: String, dataTypeEntity: DataTypeEntity): String ={
    if (dataValue != null && !dataValue.isEmpty() && dataTypeEntity.getIsList().toInt == 0 && dataTypeEntity.getIsNumeric().toInt == 0) // operandEntity.getDataTypeByOperandDataTypeId.getIsNumeric.toInt == 0
      s"'${dataValue}'"
    else if (dataValue != null && !dataValue.isEmpty() && dataTypeEntity.getIsList().toInt == 0 && dataTypeEntity.getIsNumeric().toInt == 1)
      s"%.${dataTypeEntity.getFloatPrecision}f".format(dataValue.toFloat) // format to correct floating point based off data type precision
    else if (dataValue != null && !dataValue.isEmpty() && dataTypeEntity.getIsList().toInt == 1){
      var listString = "";
      dataValue.split(',').foreach(x => {
        listString += (if (dataTypeEntity.getIsNumeric().toInt == 1) s"%.${dataTypeEntity.getFloatPrecision}f".format(x.toFloat) else s"'${x}'")
        listString += ","
      })
      listString.substring(0, listString.lastIndexOf(","))
    }
    else null
  }
}
