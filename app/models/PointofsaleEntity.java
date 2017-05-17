package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "pointofsale", schema = "metric")
public class PointofsaleEntity {
    private Integer pointofsaleId;
    private Collection<DataNodeEntity> dataNodesByPointofsaleId;
    private Collection<KpiStrategyEntity> kpiStrategiesByPointofsaleId;

    @Id
    @Column(name = "pointofsale_id", nullable = false)
    public Integer getPointofsaleId() {
        return pointofsaleId;
    }

    public void setPointofsaleId(Integer pointofsaleId) {
        this.pointofsaleId = pointofsaleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointofsaleEntity that = (PointofsaleEntity) o;

        if (pointofsaleId != null ? !pointofsaleId.equals(that.pointofsaleId) : that.pointofsaleId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pointofsaleId != null ? pointofsaleId.hashCode() : 0;
    }

    @OneToMany(mappedBy = "pointofsaleByPointofsaleId")
    public Collection<DataNodeEntity> getDataNodesByPointofsaleId() {
        return dataNodesByPointofsaleId;
    }

    public void setDataNodesByPointofsaleId(Collection<DataNodeEntity> dataNodesByPointofsaleId) {
        this.dataNodesByPointofsaleId = dataNodesByPointofsaleId;
    }

    @OneToMany(mappedBy = "pointofsaleByPointofsaleId")
    public Collection<KpiStrategyEntity> getKpiStrategiesByPointofsaleId() {
        return kpiStrategiesByPointofsaleId;
    }

    public void setKpiStrategiesByPointofsaleId(Collection<KpiStrategyEntity> kpiStrategiesByPointofsaleId) {
        this.kpiStrategiesByPointofsaleId = kpiStrategiesByPointofsaleId;
    }
}
