package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "data_type", schema = "metric")
public class DataTypeEntity {
    private Integer dataTypeId;
    private String dataType;
    private Byte isNumeric;
    private Byte isList;
    private Byte floatPrecision;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<DataFieldEntity> dataFieldsByDataTypeId;
    private Collection<MetricEntity> metricsByDataTypeId;
    private Collection<OperandEntity> operandsByDataTypeId;

    @Id
    @Column(name = "data_type_id", nullable = false)
    public Integer getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Integer dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    @Basic
    @Column(name = "data_type", nullable = false, length = 30)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "is_numeric", nullable = false)
    public Byte getIsNumeric() {
        return isNumeric;
    }

    public void setIsNumeric(Byte isNumeric) {
        this.isNumeric = isNumeric;
    }

    @Basic
    @Column(name = "float_precision", nullable = false)
    public Byte getFloatPrecision() {
        return floatPrecision;
    }

    public void setFloatPrecision(Byte floatPrecision) {
        this.floatPrecision = floatPrecision;
    }

    @Basic
    @Column(name = "is_list", nullable = false)
    public Byte getIsList() {
        return isList;
    }

    public void setIsList(Byte isList) {
        this.isList = isList;
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

        DataTypeEntity that = (DataTypeEntity) o;

        if (dataTypeId != null ? !dataTypeId.equals(that.dataTypeId) : that.dataTypeId != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (isNumeric != null ? !isNumeric.equals(that.isNumeric) : that.isNumeric != null) return false;
        if (isList != null ? !isList.equals(that.isList) : that.isList!= null) return false;
        if (floatPrecision != null ? !floatPrecision.equals(that.floatPrecision) : that.floatPrecision != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataTypeId != null ? dataTypeId.hashCode() : 0;
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (isNumeric != null ? isNumeric.hashCode() : 0);
        result = 31 * result + (isList != null ? isList.hashCode() : 0);
        result = 31 * result + (floatPrecision != null ? floatPrecision.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dataTypeByDataTypeId")
    public Collection<DataFieldEntity> getDataFieldsByDataTypeId() {
        return dataFieldsByDataTypeId;
    }

    public void setDataFieldsByDataTypeId(Collection<DataFieldEntity> dataFieldsByDataTypeId) {
        this.dataFieldsByDataTypeId = dataFieldsByDataTypeId;
    }

    @OneToMany(mappedBy = "dataTypeByResultDataTypeId")
    public Collection<MetricEntity> getMetricsByDataTypeId() {
        return metricsByDataTypeId;
    }

    public void setMetricsByDataTypeId(Collection<MetricEntity> metricsByDataTypeId) {
        this.metricsByDataTypeId = metricsByDataTypeId;
    }

    @OneToMany(mappedBy = "dataTypeByOperandDataTypeId")
    public Collection<OperandEntity> getOperandsByDataTypeId() {
        return operandsByDataTypeId;
    }

    public void setOperandsByDataTypeId(Collection<OperandEntity> operandsByDataTypeId) {
        this.operandsByDataTypeId = operandsByDataTypeId;
    }
}
