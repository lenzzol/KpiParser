package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "location", schema = "metric")
public class LocationEntity {
    private String locationId;
    private Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByLocationId;

    @Id
    @Column(name = "location_id", nullable = false, length = 36)
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return locationId != null ? locationId.hashCode() : 0;
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public Collection<KpiLocationStrategyEntity> getKpiLocationStrategiesByLocationId() {
        return kpiLocationStrategiesByLocationId;
    }

    public void setKpiLocationStrategiesByLocationId(Collection<KpiLocationStrategyEntity> kpiLocationStrategiesByLocationId) {
        this.kpiLocationStrategiesByLocationId = kpiLocationStrategiesByLocationId;
    }
}
