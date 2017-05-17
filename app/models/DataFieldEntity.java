package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "data_field", schema = "metric")
public class DataFieldEntity {
    private Integer dataFieldId;
    private String dataFieldName;
    private Integer dataTypeId;
    private Integer dataNodeId;
    private Integer dataFieldRelationshipId;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private DataTypeEntity dataTypeByDataTypeId;
    private DataNodeEntity dataNodeByDataNodeId;
    private DataFieldRelationshipEntity dataFieldRelationshipByDataFieldRelationshipId;
    private Collection<DataFieldRelationshipEntity> dataFieldRelationshipsByDataFieldId;
    private Collection<DataFieldRelationshipEntity> dataFieldRelationshipsByDataFieldId_0;
    private Collection<OperandEntity> operandsByDataFieldId;

    @Id
    @Column(name = "data_field_id", nullable = false, insertable=false, updatable=false)
    public Integer getDataFieldId() {
        return dataFieldId;
    }

    public void setDataFieldId(Integer dataFieldId) {
        this.dataFieldId = dataFieldId;
    }

    @Basic
    @Column(name = "data_field_name", nullable = false, length = 255)
    public String getDataFieldName() {
        return dataFieldName;
    }

    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }

    @Basic
    @Column(name = "data_type_id", nullable = false, insertable=false, updatable=false)
    public Integer getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    @Basic
    @Column(name = "data_node_id", nullable = false, insertable=false, updatable=false)
    public Integer getDataNodeId() {
        return dataNodeId;
    }

    public void setDataNodeId(Integer dataNodeId) {
        this.dataNodeId = dataNodeId;
    }

    @Basic
    @Column(name = "data_field_relationship_id", nullable = true, insertable=false, updatable=false)
    public Integer getDataFieldRelationshipId() {
        return dataFieldRelationshipId;
    }

    public void setDataFieldRelationshipId(Integer dataFieldRelationshipId) {
        this.dataFieldRelationshipId = dataFieldRelationshipId;
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

        DataFieldEntity that = (DataFieldEntity) o;

        if (dataFieldId != null ? !dataFieldId.equals(that.dataFieldId) : that.dataFieldId != null) return false;
        if (dataFieldName != null ? !dataFieldName.equals(that.dataFieldName) : that.dataFieldName != null)
            return false;
        if (dataTypeId != null ? !dataTypeId.equals(that.dataTypeId) : that.dataTypeId != null) return false;
        if (dataNodeId != null ? !dataNodeId.equals(that.dataNodeId) : that.dataNodeId != null) return false;
        if (dataFieldRelationshipId != null ? !dataFieldRelationshipId.equals(that.dataFieldRelationshipId) : that.dataFieldRelationshipId != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataFieldId != null ? dataFieldId.hashCode() : 0;
        result = 31 * result + (dataFieldName != null ? dataFieldName.hashCode() : 0);
        result = 31 * result + (dataTypeId != null ? dataTypeId.hashCode() : 0);
        result = 31 * result + (dataNodeId != null ? dataNodeId.hashCode() : 0);
        result = 31 * result + (dataFieldRelationshipId != null ? dataFieldRelationshipId.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "data_type_id", referencedColumnName = "data_type_id", nullable = false)
    public DataTypeEntity getDataTypeByDataTypeId() {
        return dataTypeByDataTypeId;
    }

    public void setDataTypeByDataTypeId(DataTypeEntity dataTypeByDataTypeId) {
        this.dataTypeByDataTypeId = dataTypeByDataTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "data_node_id", referencedColumnName = "data_node_id", nullable = false)
    public DataNodeEntity getDataNodeByDataNodeId() {
        return dataNodeByDataNodeId;
    }

    public void setDataNodeByDataNodeId(DataNodeEntity dataNodeByDataNodeId) {
        this.dataNodeByDataNodeId = dataNodeByDataNodeId;
    }

    @ManyToOne
    @JoinColumn(name = "data_field_relationship_id", referencedColumnName = "data_field_relationship_id")
    public DataFieldRelationshipEntity getDataFieldRelationshipByDataFieldRelationshipId() {
        return dataFieldRelationshipByDataFieldRelationshipId;
    }

    public void setDataFieldRelationshipByDataFieldRelationshipId(DataFieldRelationshipEntity dataFieldRelationshipByDataFieldRelationshipId) {
        this.dataFieldRelationshipByDataFieldRelationshipId = dataFieldRelationshipByDataFieldRelationshipId;
    }

    @OneToMany(mappedBy = "dataFieldByFieldSourceId")
    public Collection<DataFieldRelationshipEntity> getDataFieldRelationshipsByDataFieldId() {
        return dataFieldRelationshipsByDataFieldId;
    }

    public void setDataFieldRelationshipsByDataFieldId(Collection<DataFieldRelationshipEntity> dataFieldRelationshipsByDataFieldId) {
        this.dataFieldRelationshipsByDataFieldId = dataFieldRelationshipsByDataFieldId;
    }

    @OneToMany(mappedBy = "dataFieldByFieldTargetId")
    public Collection<DataFieldRelationshipEntity> getDataFieldRelationshipsByDataFieldId_0() {
        return dataFieldRelationshipsByDataFieldId_0;
    }

    public void setDataFieldRelationshipsByDataFieldId_0(Collection<DataFieldRelationshipEntity> dataFieldRelationshipsByDataFieldId_0) {
        this.dataFieldRelationshipsByDataFieldId_0 = dataFieldRelationshipsByDataFieldId_0;
    }

    @OneToMany(mappedBy = "dataFieldByOperandDataFieldId")
    public Collection<OperandEntity> getOperandsByDataFieldId() {
        return operandsByDataFieldId;
    }

    public void setOperandsByDataFieldId(Collection<OperandEntity> operandsByDataFieldId) {
        this.operandsByDataFieldId = operandsByDataFieldId;
    }
}
