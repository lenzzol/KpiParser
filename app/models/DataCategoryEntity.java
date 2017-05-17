package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
@Entity
@Table(name = "data_category", schema = "metric")
@NamedQuery(name="DataCategoryEntity.findAll", query="SELECT c FROM DataCategoryEntity c")
public class DataCategoryEntity {
    private Integer dataCategoryId;
    private String category;
    private String description;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String modifiedBy;
    private String createdBy;
    private Collection<DataNodeEntity> dataNodesByDataCategoryId;

    @Id
    @Column(name = "data_category_id", nullable = false)
    public Integer getDataCategoryId() {
        return dataCategoryId;
    }

    public void setDataCategoryId(Integer dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

        DataCategoryEntity that = (DataCategoryEntity) o;

        if (dataCategoryId != null ? !dataCategoryId.equals(that.dataCategoryId) : that.dataCategoryId != null)
            return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataCategoryId != null ? dataCategoryId.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dataCategoryByDataCategoryId")
    public Collection<DataNodeEntity> getDataNodesByDataCategoryId() {
        return dataNodesByDataCategoryId;
    }

    public void setDataNodesByDataCategoryId(Collection<DataNodeEntity> dataNodesByDataCategoryId) {
        this.dataNodesByDataCategoryId = dataNodesByDataCategoryId;
    }
}
