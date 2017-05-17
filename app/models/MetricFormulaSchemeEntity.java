package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "metric_formula_scheme", schema = "metric")
public class MetricFormulaSchemeEntity {
    private Integer metricFormulaSchemeId;
    private Integer metricId;
    private Integer metricFormulaId;
    private Integer formulaOrder;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private MetricEntity metricByMetricId;
    private MetricFormulaEntity metricFormulaByMetricFormulaId;

    @Id
    @Column(name = "metric_formula_scheme_id", nullable = false)
    public Integer getMetricFormulaSchemeId() {
        return metricFormulaSchemeId;
    }

    public void setMetricFormulaSchemeId(Integer metricFormulaSchemeId) {
        this.metricFormulaSchemeId = metricFormulaSchemeId;
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
    @Column(name = "metric_formula_id", nullable = false, insertable=false, updatable=false)
    public Integer getMetricFormulaId() {
        return metricFormulaId;
    }

    public void setMetricFormulaId(Integer metricFormulaId) {
        this.metricFormulaId = metricFormulaId;
    }

    @Basic
    @Column(name = "formula_order", nullable = false)
    public Integer getFormulaOrder() {
        return formulaOrder;
    }

    public void setFormulaOrder(Integer formulaOrder) {
        this.formulaOrder = formulaOrder;
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

        MetricFormulaSchemeEntity that = (MetricFormulaSchemeEntity) o;

        if (metricFormulaSchemeId != null ? !metricFormulaSchemeId.equals(that.metricFormulaSchemeId) : that.metricFormulaSchemeId != null)
            return false;
        if (metricId != null ? !metricId.equals(that.metricId) : that.metricId != null) return false;
        if (metricFormulaId != null ? !metricFormulaId.equals(that.metricFormulaId) : that.metricFormulaId != null)
            return false;
        if (formulaOrder != null ? !formulaOrder.equals(that.formulaOrder) : that.formulaOrder != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = metricFormulaSchemeId != null ? metricFormulaSchemeId.hashCode() : 0;
        result = 31 * result + (metricId != null ? metricId.hashCode() : 0);
        result = 31 * result + (metricFormulaId != null ? metricFormulaId.hashCode() : 0);
        result = 31 * result + (formulaOrder != null ? formulaOrder.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "metric_formula_id", referencedColumnName = "metric_formula_id", nullable = false)
    public MetricFormulaEntity getMetricFormulaByMetricFormulaId() {
        return metricFormulaByMetricFormulaId;
    }

    public void setMetricFormulaByMetricFormulaId(MetricFormulaEntity metricFormulaByMetricFormulaId) {
        this.metricFormulaByMetricFormulaId = metricFormulaByMetricFormulaId;
    }
}
