package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "data_node", schema = "metric")
public class DataNodeEntity {
    private Integer dataNodeId;
    private String nodeName;
    private Integer pointofsaleId;
    private Integer dataCategoryId;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<DataFieldEntity> dataFieldsByDataNodeId;
    private PointofsaleEntity pointofsaleByPointofsaleId;
    private DataCategoryEntity dataCategoryByDataCategoryId;

    @Id
    @Column(name = "data_node_id", nullable = false)
    public Integer getDataNodeId() {
        return dataNodeId;
    }

    public void setDataNodeId(Integer dataNodeId) {
        this.dataNodeId = dataNodeId;
    }

    @Basic
    @Column(name = "node_name", nullable = false, length = 30)
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
    @Column(name = "data_category_id", nullable = false, insertable=false, updatable=false)
    public Integer getDataCategoryId() {
        return dataCategoryId;
    }

    public void setDataCategoryId(Integer dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
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

        DataNodeEntity that = (DataNodeEntity) o;

        if (dataNodeId != null ? !dataNodeId.equals(that.dataNodeId) : that.dataNodeId != null) return false;
        if (nodeName != null ? !nodeName.equals(that.nodeName) : that.nodeName != null) return false;
        if (pointofsaleId != null ? !pointofsaleId.equals(that.pointofsaleId) : that.pointofsaleId != null)
            return false;
        if (dataCategoryId != null ? !dataCategoryId.equals(that.dataCategoryId) : that.dataCategoryId != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataNodeId != null ? dataNodeId.hashCode() : 0;
        result = 31 * result + (nodeName != null ? nodeName.hashCode() : 0);
        result = 31 * result + (pointofsaleId != null ? pointofsaleId.hashCode() : 0);
        result = 31 * result + (dataCategoryId != null ? dataCategoryId.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dataNodeByDataNodeId")
    public Collection<DataFieldEntity> getDataFieldsByDataNodeId() {
        return dataFieldsByDataNodeId;
    }

    public void setDataFieldsByDataNodeId(Collection<DataFieldEntity> dataFieldsByDataNodeId) {
        this.dataFieldsByDataNodeId = dataFieldsByDataNodeId;
    }

    @ManyToOne
    @JoinColumn(name = "pointofsale_id", referencedColumnName = "pointofsale_id", nullable = false)
    public PointofsaleEntity getPointofsaleByPointofsaleId() {
        return pointofsaleByPointofsaleId;
    }

    public void setPointofsaleByPointofsaleId(PointofsaleEntity pointofsaleByPointofsaleId) {
        this.pointofsaleByPointofsaleId = pointofsaleByPointofsaleId;
    }

    @ManyToOne
    @JoinColumn(name = "data_category_id", referencedColumnName = "data_category_id", nullable = false)
    public DataCategoryEntity getDataCategoryByDataCategoryId() {
        return dataCategoryByDataCategoryId;
    }

    public void setDataCategoryByDataCategoryId(DataCategoryEntity dataCategoryByDataCategoryId) {
        this.dataCategoryByDataCategoryId = dataCategoryByDataCategoryId;
    }
}
