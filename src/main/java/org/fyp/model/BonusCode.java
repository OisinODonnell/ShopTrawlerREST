package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "bonuscodes", schema = "shoptrawler")
public class BonusCode extends BaseEntity {
    private int bonusCodeid;
    private Timestamp datetime;
    private Integer retailerid;
    private Integer userid;
    private String value;
    private Retailer retailersByRetailerid;
    private User usersByUserid;

    public BonusCode() {
    }

    public BonusCode(List<String> attributes)  {
        this.bonusCodeid    = toInteger( attributes.get(0));
        this.retailerid     = toInteger( attributes.get(1));
        this.value          = attributes.get(2);
//        this.userid         = toInteger( attributes.get(3));
//        this.datetime       = toTimestamp( attributes.get(4));
    }
    @Id
    @Column(name = "bonus_codeid", nullable = false)
    public int getBonusCodeid() {
        return bonusCodeid;
    }

    public void setBonusCodeid(int bonusCodeid) {
        this.bonusCodeid = bonusCodeid;
    }

    @Basic
    @Column(name = "datetime", nullable = true)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "retailerid", nullable = true)
    public Integer getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(Integer retailerid) {
        this.retailerid = retailerid;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 255)
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

        if (bonusCodeid != bonusCode.bonusCodeid) return false;
        if (datetime != null ? !datetime.equals(bonusCode.datetime) : bonusCode.datetime != null) return false;
        if (retailerid != null ? !retailerid.equals(bonusCode.retailerid) : bonusCode.retailerid != null) return false;
        if (userid != null ? !userid.equals(bonusCode.userid) : bonusCode.userid != null) return false;
        if (value != null ? !value.equals(bonusCode.value) : bonusCode.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bonusCodeid;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (retailerid != null ? retailerid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "retailerid", referencedColumnName = "retailerid",insertable = false, updatable = false)
    public Retailer getRetailersByRetailerid() {
        return retailersByRetailerid;
    }

    public void setRetailersByRetailerid(Retailer retailersByRetailerid) {
        this.retailersByRetailerid = retailersByRetailerid;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid",insertable = false, updatable = false)
    public User getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(User usersByUserid) {
        this.usersByUserid = usersByUserid;
    }
}
