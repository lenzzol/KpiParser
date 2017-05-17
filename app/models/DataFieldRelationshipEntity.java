package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "data_field_relationship", schema = "metric")
public class DataFieldRelationshipEntity {
    private Integer dataFieldRelationshipId;
    private Integer fieldSourceId;
    private Integer fieldTargetId;
    private Collection<DataFieldEntity> dataFieldsByDataFieldRelationshipId;
    private DataFieldEntity dataFieldByFieldSourceId;
    private DataFieldEntity dataFieldByFieldTargetId;

    @Id
    @Column(name = "data_field_relationship_id", nullable = false)
    public Integer getDataFieldRelationshipId() {
        return dataFieldRelationshipId;
    }

    public void setDataFieldRelationshipId(Integer dataFieldRelationshipId) {
        this.dataFieldRelationshipId = dataFieldRelationshipId;
    }

    @Basic
    @Column(name = "field_source_id", nullable = false, insertable=false, updatable=false)
    public Integer getFieldSourceId() {
        return fieldSourceId;
    }

    public void setFieldSourceId(Integer fieldSourceId) {
        this.fieldSourceId = fieldSourceId;
    }

    @Basic
    @Column(name = "field_target_id", nullable = false, insertable=false, updatable=false)
    public Integer getFieldTargetId() {
        return fieldTargetId;
    }

    public void setFieldTargetId(Integer fieldTargetId) {
        this.fieldTargetId = fieldTargetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataFieldRelationshipEntity that = (DataFieldRelationshipEntity) o;

        if (dataFieldRelationshipId != null ? !dataFieldRelationshipId.equals(that.dataFieldRelationshipId) : that.dataFieldRelationshipId != null)
            return false;
        if (fieldSourceId != null ? !fieldSourceId.equals(that.fieldSourceId) : that.fieldSourceId != null)
            return false;
        if (fieldTargetId != null ? !fieldTargetId.equals(that.fieldTargetId) : that.fieldTargetId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataFieldRelationshipId != null ? dataFieldRelationshipId.hashCode() : 0;
        result = 31 * result + (fieldSourceId != null ? fieldSourceId.hashCode() : 0);
        result = 31 * result + (fieldTargetId != null ? fieldTargetId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dataFieldRelationshipByDataFieldRelationshipId")
    public Collection<DataFieldEntity> getDataFieldsByDataFieldRelationshipId() {
        return dataFieldsByDataFieldRelationshipId;
    }

    public void setDataFieldsByDataFieldRelationshipId(Collection<DataFieldEntity> dataFieldsByDataFieldRelationshipId) {
        this.dataFieldsByDataFieldRelationshipId = dataFieldsByDataFieldRelationshipId;
    }

    @ManyToOne
    @JoinColumn(name = "field_source_id", referencedColumnName = "data_field_id", nullable = false)
    public DataFieldEntity getDataFieldByFieldSourceId() {
        return dataFieldByFieldSourceId;
    }

    public void setDataFieldByFieldSourceId(DataFieldEntity dataFieldByFieldSourceId) {
        this.dataFieldByFieldSourceId = dataFieldByFieldSourceId;
    }

    @ManyToOne
    @JoinColumn(name = "field_target_id", referencedColumnName = "data_field_id", nullable = false)
    public DataFieldEntity getDataFieldByFieldTargetId() {
        return dataFieldByFieldTargetId;
    }

    public void setDataFieldByFieldTargetId(DataFieldEntity dataFieldByFieldTargetId) {
        this.dataFieldByFieldTargetId = dataFieldByFieldTargetId;
    }
}
