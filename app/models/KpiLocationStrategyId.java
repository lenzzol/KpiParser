package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Len on 2/21/2017.
 */

@Embeddable
public class KpiLocationStrategyId implements Serializable{
    private Integer kpiId;
    private String locationId;

    @Basic
    @Column(name = "kpi_id", nullable = false, insertable=false, updatable=false)
    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    @Basic
    @Column(name = "location_id", nullable = false, length = 36)
    public String getLocationId() { return locationId; }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
