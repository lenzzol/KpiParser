package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "kpi", schema = "metric")
public class KpiEntity {
    private Integer kpiId;
    private String name;
    private String description;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByKpiId;
    private Collection<KpiStrategyEntity> kpiStrategiesByKpiId;

    @Id
    @Column(name = "kpi_id", nullable = false, insertable=false, updatable=false)
    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        KpiEntity kpiEntity = (KpiEntity) o;

        if (kpiId != null ? !kpiId.equals(kpiEntity.kpiId) : kpiEntity.kpiId != null) return false;
        if (name != null ? !name.equals(kpiEntity.name) : kpiEntity.name != null) return false;
        if (description != null ? !description.equals(kpiEntity.description) : kpiEntity.description != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(kpiEntity.modifiedDate) : kpiEntity.modifiedDate != null)
            return false;
        if (createdDate != null ? !createdDate.equals(kpiEntity.createdDate) : kpiEntity.createdDate != null)
            return false;
        if (modifiedBy != null ? !modifiedBy.equals(kpiEntity.modifiedBy) : kpiEntity.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(kpiEntity.createdBy) : kpiEntity.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kpiId != null ? kpiId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kpiByKpiId")
    public Collection<KpiLocationStrategyEntity> getKpiLocationStrategiesByKpiId() {
        return kpiLocationStrategiesByKpiId;
    }

    public void setKpiLocationStrategiesByKpiId(Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByKpiId) {
        this.kpiLocationStrategiesByKpiId = kpiLocationStrategiesByKpiId;
    }

    @OneToMany(mappedBy = "kpiByKpiId")
    public Collection<KpiStrategyEntity> getKpiStrategiesByKpiId() {
        return kpiStrategiesByKpiId;
    }

    public void setKpiStrategiesByKpiId(Collection<KpiStrategyEntity> kpiStrategiesByKpiId) {
        this.kpiStrategiesByKpiId = kpiStrategiesByKpiId;
    }
}
