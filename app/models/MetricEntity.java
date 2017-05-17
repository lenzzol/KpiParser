package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "metric", schema = "metric")
public class MetricEntity {
    private Integer metricId;
    private String metric;
    private String defaultResultValue;
    private Integer resultDataTypeId;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private DataTypeEntity dataTypeByResultDataTypeId;
    private Collection<MetricFormulaSchemeEntity> metricFormulaSchemesByMetricId;
    private Collection<MetricSchemeEntity> metricSchemesByMetricId;

    @Id
    @Column(name = "metric_id", nullable = false)
    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
    }

    @Basic
    @Column(name = "metric", nullable = false, length = 255)
    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    @Basic
    @Column(name = "default_result_value", nullable = true, length = 30)
    public String getDefaultResultValue() {
        return defaultResultValue;
    }

    public void setDefaultResultValue(String defaultResultValue) {
        this.defaultResultValue = defaultResultValue;
    }

    @Basic
    @Column(name = "result_data_type_id", nullable = true, insertable=false, updatable=false)
    public Integer getResultDataTypeId() {
        return resultDataTypeId;
    }

    public void setResultDataTypeId(Integer resultDataTypeId) {
        this.resultDataTypeId = resultDataTypeId;
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

        MetricEntity that = (MetricEntity) o;

        if (metricId != null ? !metricId.equals(that.metricId) : that.metricId != null) return false;
        if (metric != null ? !metric.equals(that.metric) : that.metric != null) return false;
        if (defaultResultValue != null ? !defaultResultValue.equals(that.defaultResultValue) : that.defaultResultValue != null)
            return false;
        if (resultDataTypeId != null ? !resultDataTypeId.equals(that.resultDataTypeId) : that.resultDataTypeId != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = metricId != null ? metricId.hashCode() : 0;
        result = 31 * result + (metric != null ? metric.hashCode() : 0);
        result = 31 * result + (defaultResultValue != null ? defaultResultValue.hashCode() : 0);
        result = 31 * result + (resultDataTypeId != null ? resultDataTypeId.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "result_data_type_id", referencedColumnName = "data_type_id")
    public DataTypeEntity getDataTypeByResultDataTypeId() {
        return dataTypeByResultDataTypeId;
    }

    public void setDataTypeByResultDataTypeId(DataTypeEntity dataTypeByResultDataTypeId) {
        this.dataTypeByResultDataTypeId = dataTypeByResultDataTypeId;
    }

    @OneToMany(mappedBy = "metricByMetricId")
    public Collection<MetricFormulaSchemeEntity> getMetricFormulaSchemesByMetricId() {
        return metricFormulaSchemesByMetricId;
    }

    public void setMetricFormulaSchemesByMetricId(Collection<MetricFormulaSchemeEntity> metricFormulaSchemesByMetricId) {
        this.metricFormulaSchemesByMetricId = metricFormulaSchemesByMetricId;
    }

    @OneToMany(mappedBy = "metricByMetricId")
    public Collection<MetricSchemeEntity> getMetricSchemesByMetricId() {
        return metricSchemesByMetricId;
    }

    public void setMetricSchemesByMetricId(Collection<MetricSchemeEntity> metricSchemesByMetricId) {
        this.metricSchemesByMetricId = metricSchemesByMetricId;
    }
}
