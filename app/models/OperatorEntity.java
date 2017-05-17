package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "operator", schema = "metric")
public class OperatorEntity {
    private Integer operatorId;
    private String operator;
    private String operatorType;
    private String symbol;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<FormulaOperationEntity> formulaOperationsByOperatorId;
    private Collection<MetricSchemeEntity> metricSchemesByOperatorId;

    @Id
    @Column(name = "operator_id", nullable = false)
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operator", nullable = false, length = 50)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "operator_type", nullable = false, length = 50)
    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    @Basic
    @Column(name = "symbol", nullable = true, length = 10)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

        OperatorEntity that = (OperatorEntity) o;

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (operatorType != null ? !operatorType.equals(that.operatorType) : that.operatorType != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operatorId != null ? operatorId.hashCode() : 0;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatorType != null ? operatorType.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "operatorByOperatorId")
    public Collection<FormulaOperationEntity> getFormulaOperationsByOperatorId() {
        return formulaOperationsByOperatorId;
    }

    public void setFormulaOperationsByOperatorId(Collection<FormulaOperationEntity> formulaOperationsByOperatorId) {
        this.formulaOperationsByOperatorId = formulaOperationsByOperatorId;
    }

    @OneToMany(mappedBy = "operatorByOperatorId")
    public Collection<MetricSchemeEntity> getMetricSchemesByOperatorId() {
        return metricSchemesByOperatorId;
    }

    public void setMetricSchemesByOperatorId(Collection<MetricSchemeEntity> metricSchemesByOperatorId) {
        this.metricSchemesByOperatorId = metricSchemesByOperatorId;
    }
}
