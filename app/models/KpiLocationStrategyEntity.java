package models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "kpi_location_strategy", schema = "metric")
public class KpiLocationStrategyEntity {
    private Integer kpiStrategyId;
    private Integer kpiId;
    private String locationId;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private KpiStrategyEntity kpiStrategyByKpiStrategyId;
    private KpiEntity kpiByKpiId;
    private LocationEntity locationByLocationId;
    private KpiLocationStrategyId kpiLocationStrategyId;

    @Basic
    @Column(name = "kpi_strategy_id", nullable = false)
    public Integer getKpiStrategyId() {
        return kpiStrategyId;
    }

    public void setKpiStrategyId(Integer kpiStrategyId) {
        this.kpiStrategyId = kpiStrategyId;
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

    @EmbeddedId
    public KpiLocationStrategyId getKpiLocationStrategyId() { return kpiLocationStrategyId; }

    public void setKpiLocationStrategyId(KpiLocationStrategyId kpiLocationStrategyId) { this.kpiLocationStrategyId = kpiLocationStrategyId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KpiLocationStrategyEntity that = (KpiLocationStrategyEntity) o;

        if (kpiStrategyId != null ? !kpiStrategyId.equals(that.kpiStrategyId) : that.kpiStrategyId != null)
            return false;
        if (kpiId != null ? !kpiId.equals(that.kpiId) : that.kpiId != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kpiStrategyId != null ? kpiStrategyId.hashCode() : 0;
        result = 31 * result + (kpiId != null ? kpiId.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "kpi_strategy_id", referencedColumnName = "kpi_strategy_id", nullable = false, insertable=false, updatable=false)
    public KpiStrategyEntity getKpiStrategyByKpiStrategyId() {
        return kpiStrategyByKpiStrategyId;
    }

    public void setKpiStrategyByKpiStrategyId(KpiStrategyEntity kpiStrategyByKpiStrategyId) {
        this.kpiStrategyByKpiStrategyId = kpiStrategyByKpiStrategyId;
    }

    @ManyToOne
    @JoinColumn(name = "kpi_id", referencedColumnName = "kpi_id", nullable = false, insertable=false, updatable=false)
    public KpiEntity getKpiByKpiId() {
        return kpiByKpiId;
    }

    public void setKpiByKpiId(KpiEntity kpiByKpiId) {
        this.kpiByKpiId = kpiByKpiId;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false, insertable=false, updatable=false)
    public LocationEntity getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(LocationEntity locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }
}
