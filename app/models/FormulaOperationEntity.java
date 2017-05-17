package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "formula_operation", schema = "metric")
@NamedNativeQuery(
        name="formulaByMetricName",
        query = "select fo.formula_operation_id, fo.metric_formula_id, fo.operand_id, fo.operator_id, " +
                "fo.operation_order, fo.modified_date, fo.created_date, fo.modified_by, fo.created_by " +
                "from metric_scheme as ms left join kpi_strategy as ks on ms.kpi_strategy_id = ks.kpi_strategy_id " +
                "left join metric as m on ms.metric_id = m.metric_id " +
                "left join kpi as k on ks.kpi_id = k.kpi_id " +
                "join metric_formula_scheme as mfs on mfs.metric_id = ms.metric_id " +
                "join formula_operation as fo on mfs.metric_formula_id = fo.metric_formula_id " +
                "where k.name = 'Total Sales' and ks.pointofsale_id = 10",
        resultClass = FormulaOperationEntity.class
)

public class FormulaOperationEntity {
    private Integer formulaOperationId;
    private Integer metricFormulaId;
    private Integer operandId;
    private Integer operatorId;
    private Integer operationOrder;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private MetricFormulaEntity metricFormulaByMetricFormulaId;
    private OperandEntity operandByOperandId;
    private OperatorEntity operatorByOperatorId;

    @Id
    @Column(name = "formula_operation_id", nullable = false)
    public Integer getFormulaOperationId() {
        return formulaOperationId;
    }

    public void setFormulaOperationId(Integer formulaOperationId) {
        this.formulaOperationId = formulaOperationId;
    }

    @Basic
    @Column(name = "metric_formula_id", nullable = false, insertable=false, updatable=false)
    public Integer getMetricFormulaId() {
        return metricFormulaId;
    }

    public void setMetricFormulaId(Integer metricFormulaId) {
        this.metricFormulaId = metricFormulaId;
    }

    @Basic
    @Column(name = "operand_id", nullable = false, insertable=false, updatable=false)
    public Integer getOperandId() {
        return operandId;
    }

    public void setOperandId(Integer operandId) {
        this.operandId = operandId;
    }

    @Basic
    @Column(name = "operator_id", nullable = false, insertable=false, updatable=false)
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operation_order", nullable = false)
    public Integer getOperationOrder() {
        return operationOrder;
    }

    public void setOperationOrder(Integer operationOrder) {
        this.operationOrder = operationOrder;
    }

    @Basic
    @Column(name = "modified_date", nullable = true)
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "modified_by", nullable = true, length = 36)
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "created_by", nullable = false, length = 36)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormulaOperationEntity that = (FormulaOperationEntity) o;

        if (formulaOperationId != null ? !formulaOperationId.equals(that.formulaOperationId) : that.formulaOperationId != null)
            return false;
        if (metricFormulaId != null ? !metricFormulaId.equals(that.metricFormulaId) : that.metricFormulaId != null)
            return false;
        if (operandId != null ? !operandId.equals(that.operandId) : that.operandId != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operationOrder != null ? !operationOrder.equals(that.operationOrder) : that.operationOrder != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = formulaOperationId != null ? formulaOperationId.hashCode() : 0;
        result = 31 * result + (metricFormulaId != null ? metricFormulaId.hashCode() : 0);
        result = 31 * result + (operandId != null ? operandId.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operationOrder != null ? operationOrder.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "metric_formula_id", referencedColumnName = "metric_formula_id", nullable = false)
    public MetricFormulaEntity getMetricFormulaByMetricFormulaId() {
        return metricFormulaByMetricFormulaId;
    }

    public void setMetricFormulaByMetricFormulaId(MetricFormulaEntity metricFormulaByMetricFormulaId) {
        this.metricFormulaByMetricFormulaId = metricFormulaByMetricFormulaId;
    }

    @ManyToOne
    @JoinColumn(name = "operand_id", referencedColumnName = "operand_id", nullable = false)
    public OperandEntity getOperandByOperandId() {
        return operandByOperandId;
    }

    public void setOperandByOperandId(OperandEntity operandByOperandId) {
        this.operandByOperandId = operandByOperandId;
    }

    @ManyToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "operator_id", nullable = false)
    public OperatorEntity getOperatorByOperatorId() {
        return operatorByOperatorId;
    }

    public void setOperatorByOperatorId(OperatorEntity operatorByOperatorId) {
        this.operatorByOperatorId = operatorByOperatorId;
    }
}
