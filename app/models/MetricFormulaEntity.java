package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "metric_formula", schema = "metric")
public class MetricFormulaEntity {
    private Integer metricFormulaId;
    private String description;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<FormulaOperationEntity> formulaOperationsByMetricFormulaId;
    private Collection<MetricFormulaSchemeEntity> metricFormulaSchemesByMetricFormulaId;

    @Id
    @Column(name = "metric_formula_id", nullable = false, insertable=false, updatable=false)
    public Integer getMetricFormulaId() {
        return metricFormulaId;
    }

    public void setMetricFormulaId(Integer metricFormulaId) {
        this.metricFormulaId = metricFormulaId;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        MetricFormulaEntity that = (MetricFormulaEntity) o;

        if (metricFormulaId != null ? !metricFormulaId.equals(that.metricFormulaId) : that.metricFormulaId != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = metricFormulaId != null ? metricFormulaId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "metricFormulaByMetricFormulaId")
    public Collection<FormulaOperationEntity> getFormulaOperationsByMetricFormulaId() {
        return formulaOperationsByMetricFormulaId;
    }

    public void setFormulaOperationsByMetricFormulaId(Collection<FormulaOperationEntity> formulaOperationsByMetricFormulaId) {
        this.formulaOperationsByMetricFormulaId = formulaOperationsByMetricFormulaId;
    }

    @OneToMany(mappedBy = "metricFormulaByMetricFormulaId")
    public Collection<MetricFormulaSchemeEntity> getMetricFormulaSchemesByMetricFormulaId() {
        return metricFormulaSchemesByMetricFormulaId;
    }

    public void setMetricFormulaSchemesByMetricFormulaId(Collection<MetricFormulaSchemeEntity> metricFormulaSchemesByMetricFormulaId) {
        this.metricFormulaSchemesByMetricFormulaId = metricFormulaSchemesByMetricFormulaId;
    }
}
