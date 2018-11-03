package kg.gov.mf.loan.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mflog")
public class MFLog extends GenericModel
{
    private String createdBy;
    private Date createdDate = new Date();
    private String entity;
    private Long entityId;
    private String action;
    private String ip;

    //region GET-SET
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    //endregion
}
