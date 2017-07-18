package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "bonuscodes", schema = "shoptrawler", catalog = "")
public class BonusCode {
    private int bonusCodeId;
    private Integer retailerId;
    private Integer userId;
    private Timestamp datetime;
    private String value;

    @Id
    @Column(name = "bonusCodeID")
    public int getBonusCodeId() {
        return bonusCodeId;
    }

    public void setBonusCodeId(int bonusCodeId) {
        this.bonusCodeId = bonusCodeId;
    }

    @Basic
    @Column(name = "retailerID")
    public Integer getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Integer retailerId) {
        this.retailerId = retailerId;
    }

    @Basic
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "datetime")
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BonusCode bonusCode = (BonusCode) o;

        if (bonusCodeId != bonusCode.bonusCodeId) return false;
        if (retailerId != null ? !retailerId.equals(bonusCode.retailerId) : bonusCode.retailerId != null) return false;
        if (userId != null ? !userId.equals(bonusCode.userId) : bonusCode.userId != null) return false;
        if (datetime != null ? !datetime.equals(bonusCode.datetime) : bonusCode.datetime != null) return false;
        if (value != null ? !value.equals(bonusCode.value) : bonusCode.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bonusCodeId;
        result = 31 * result + (retailerId != null ? retailerId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
