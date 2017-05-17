package models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@NamedQuery(
        name = "MetricSchemeEntity.findByKpiStrategyOrdered",
        query = "SELECT m FROM MetricSchemeEntity m WHERE m.kpiStrategyId = :kpiStrategyId ORDER BY m.metricSchemeId"
)
@Table(name = "metric_scheme", schema = "metric")
public class MetricSchemeEntity implements Serializable {
    private Integer metricSchemeId;
    private Integer kpiStrategyId;
    private Integer metricId;
    private Integer operatorId;
    private Integer operationOrder;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private KpiStrategyEntity kpiStrategyByKpiStrategyId;
    private MetricEntity metricByMetricId;
    private OperatorEntity operatorByOperatorId;

    @Id
    @Column(name = "metric_scheme_id", nullable = false, insertable=false, updatable=false)
    public Integer getMetricSchemeId() {
        return metricSchemeId;
    }

    public void setMetricSchemeId(Integer metricSchemeId) {
        this.metricSchemeId = metricSchemeId;
    }

    @Basic
    @Column(name = "kpi_strategy_id", nullable = false, insertable=false, updatable=false)
    public Integer getKpiStrategyId() {
        return kpiStrategyId;
    }

    public void setKpiStrategyId(Integer kpiStrategyId) {
        this.kpiStrategyId = kpiStrategyId;
    }

    @Basic
    @Column(name = "metric_id", nullable = false, insertable=false, updatable=false)
    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
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

        MetricSchemeEntity that = (MetricSchemeEntity) o;

        if (metricSchemeId != null ? !metricSchemeId.equals(that.metricSchemeId) : that.metricSchemeId != null)
            return false;
        if (kpiStrategyId != null ? !kpiStrategyId.equals(that.kpiStrategyId) : that.kpiStrategyId != null)
            return false;
        if (metricId != null ? !metricId.equals(that.metricId) : that.metricId != null) return false;
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
        int result = metricSchemeId != null ? metricSchemeId.hashCode() : 0;
        result = 31 * result + (kpiStrategyId != null ? kpiStrategyId.hashCode() : 0);
        result = 31 * result + (metricId != null ? metricId.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operationOrder != null ? operationOrder.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "kpi_strategy_id", referencedColumnName = "kpi_strategy_id", nullable = false)
    public KpiStrategyEntity getKpiStrategyByKpiStrategyId() {
        return kpiStrategyByKpiStrategyId;
    }

    public void setKpiStrategyByKpiStrategyId(KpiStrategyEntity kpiStrategyByKpiStrategyId) {
        this.kpiStrategyByKpiStrategyId = kpiStrategyByKpiStrategyId;
    }

    @ManyToOne
    @JoinColumn(name = "metric_id", referencedColumnName = "metric_id", nullable = false)
    public MetricEntity getMetricByMetricId() {
        return metricByMetricId;
    }

    public void setMetricByMetricId(MetricEntity metricByMetricId) {
        this.metricByMetricId = metricByMetricId;
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
