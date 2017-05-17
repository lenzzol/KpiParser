package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Len on 2/21/2017.
 */
public class OperandDataObject {
    private Integer operandId;
    private String dataField;
    private String nodeName;

    public Integer getOperandId() {
        return operandId;
    }

    public void setOperandId(Integer operandId) {
        this.operandId = operandId;
    }

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
