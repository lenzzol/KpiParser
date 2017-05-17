package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity

@Table(name = "operand", schema = "metric")
public class OperandEntity {
    private Integer operandId;
    private String operandValue;
    private Integer operandDataFieldId;
    private Integer operandDataTypeId;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<FormulaOperationEntity> formulaOperationsByOperandId;
    private DataFieldEntity dataFieldByOperandDataFieldId;
    private DataTypeEntity dataTypeByOperandDataTypeId;

    @Id
    @Column(name = "operand_id", nullable = false)
    public Integer getOperandId() {
        return operandId;
    }

    public void setOperandId(Integer operandId) {
        this.operandId = operandId;
    }

    @Basic
    @Column(name = "operand_value", nullable = true, length = 30)
    public String getOperandValue() {
        return operandValue;
    }

    public void setOperandValue(String operandValue) {
        this.operandValue = operandValue;
    }

    @Basic
    @Column(name = "operand_data_field_id", nullable = true, insertable=false, updatable=false)
    public Integer getOperandDataFieldId() {
        return operandDataFieldId;
    }

    public void setOperandDataFieldId(Integer operandDataFieldId) {
        this.operandDataFieldId = operandDataFieldId;
    }

    @Basic
    @Column(name = "operand_data_type_id", nullable = false, insertable=false, updatable=false)
    public Integer getOperandDataTypeId() {
        return operandDataTypeId;
    }

    public void setOperandDataTypeId(Integer operandDataTypeId) {
        this.operandDataTypeId = operandDataTypeId;
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

        OperandEntity that = (OperandEntity) o;

        if (operandId != null ? !operandId.equals(that.operandId) : that.operandId != null) return false;
        if (operandValue != null ? !operandValue.equals(that.operandValue) : that.operandValue != null) return false;
        if (operandDataFieldId != null ? !operandDataFieldId.equals(that.operandDataFieldId) : that.operandDataFieldId != null)
            return false;
        if (operandDataTypeId != null ? !operandDataTypeId.equals(that.operandDataTypeId) : that.operandDataTypeId != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operandId != null ? operandId.hashCode() : 0;
        result = 31 * result + (operandValue != null ? operandValue.hashCode() : 0);
        result = 31 * result + (operandDataFieldId != null ? operandDataFieldId.hashCode() : 0);
        result = 31 * result + (operandDataTypeId != null ? operandDataTypeId.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "operandByOperandId")
    public Collection<FormulaOperationEntity> getFormulaOperationsByOperandId() {
        return formulaOperationsByOperandId;
    }

    public void setFormulaOperationsByOperandId(Collection<FormulaOperationEntity> formulaOperationsByOperandId) {
        this.formulaOperationsByOperandId = formulaOperationsByOperandId;
    }

    @ManyToOne
    @JoinColumn(name = "operand_data_field_id", referencedColumnName = "data_field_id")
    public DataFieldEntity getDataFieldByOperandDataFieldId() {
        return dataFieldByOperandDataFieldId;
    }

    public void setDataFieldByOperandDataFieldId(DataFieldEntity dataFieldByOperandDataFieldId) {
        this.dataFieldByOperandDataFieldId = dataFieldByOperandDataFieldId;
    }

    @ManyToOne
    @JoinColumn(name = "operand_data_type_id", referencedColumnName = "data_type_id", nullable = false)
    public DataTypeEntity getDataTypeByOperandDataTypeId() {
        return dataTypeByOperandDataTypeId;
    }

    public void setDataTypeByOperandDataTypeId(DataTypeEntity dataTypeByOperandDataTypeId) {
        this.dataTypeByOperandDataTypeId = dataTypeByOperandDataTypeId;
    }
}
