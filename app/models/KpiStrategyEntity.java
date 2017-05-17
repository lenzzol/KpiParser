package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "kpi_strategy", schema = "metric")
public class KpiStrategyEntity {
    private Integer kpiStrategyId;
    private String description;
    private Integer kpiId;
    private Integer pointofsaleId;
    private Byte isSystem;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByKpiStrategyId;
    private KpiEntity kpiByKpiId;
    private PointofsaleEntity pointofsaleByPointofsaleId;
    private Collection<MetricSchemeEntity> metricSchemesByKpiStrategyId;

    @Id
    @Column(name = "kpi_strategy_id", nullable = false)
    public Integer getKpiStrategyId() {
        return kpiStrategyId;
    }

    public void setKpiStrategyId(Integer kpiStrategyId) {
        this.kpiStrategyId = kpiStrategyId;
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
    @Column(name = "kpi_id", nullable = false, insertable=false, updatable=false)
    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    @Basic
    @Column(name = "pointofsale_id", nullable = false, insertable=false, updatable=false)
    public Integer getPointofsaleId() {
        return pointofsaleId;
    }

    public void setPointofsaleId(Integer pointofsaleId) {
        this.pointofsaleId = pointofsaleId;
    }

    @Basic
    @Column(name = "is_system", nullable = false)
    public Byte getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
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

        KpiStrategyEntity that = (KpiStrategyEntity) o;

        if (kpiStrategyId != null ? !kpiStrategyId.equals(that.kpiStrategyId) : that.kpiStrategyId != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (kpiId != null ? !kpiId.equals(that.kpiId) : that.kpiId != null) return false;
        if (pointofsaleId != null ? !pointofsaleId.equals(that.pointofsaleId) : that.pointofsaleId != null)
            return false;
        if (isSystem != null ? !isSystem.equals(that.isSystem) : that.isSystem != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kpiStrategyId != null ? kpiStrategyId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (kpiId != null ? kpiId.hashCode() : 0);
        result = 31 * result + (pointofsaleId != null ? pointofsaleId.hashCode() : 0);
        result = 31 * result + (isSystem != null ? isSystem.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kpiStrategyByKpiStrategyId")
    public Collection<KpiLocationStrategyEntity> getKpiLocationStrategiesByKpiStrategyId() {
        return kpiLocationStrategiesByKpiStrategyId;
    }

    public void setKpiLocationStrategiesByKpiStrategyId(Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByKpiStrategyId) {
        this.kpiLocationStrategiesByKpiStrategyId = kpiLocationStrategiesByKpiStrategyId;
    }

    @ManyToOne
    @JoinColumn(name = "kpi_id", referencedColumnName = "kpi_id", nullable = false)
    public KpiEntity getKpiByKpiId() {
        return kpiByKpiId;
    }

    public void setKpiByKpiId(KpiEntity kpiByKpiId) {
        this.kpiByKpiId = kpiByKpiId;
    }

    @ManyToOne
    @JoinColumn(name = "pointofsale_id", referencedColumnName = "pointofsale_id", nullable = false)
    public PointofsaleEntity getPointofsaleByPointofsaleId() {
        return pointofsaleByPointofsaleId;
    }

    public void setPointofsaleByPointofsaleId(PointofsaleEntity pointofsaleByPointofsaleId) {
        this.pointofsaleByPointofsaleId = pointofsaleByPointofsaleId;
    }

    @OneToMany(mappedBy = "kpiStrategyByKpiStrategyId")
    public Collection<MetricSchemeEntity> getMetricSchemesByKpiStrategyId() {
        return metricSchemesByKpiStrategyId;
    }

    public void setMetricSchemesByKpiStrategyId(Collection<MetricSchemeEntity> metricSchemesByKpiStrategyId) {
        this.metricSchemesByKpiStrategyId = metricSchemesByKpiStrategyId;
    }
}
