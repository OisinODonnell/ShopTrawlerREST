package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VisitPK implements Serializable {
    private int zoneid;
    private int visitid;
    private int userid;

    @Column(name = "zoneid", nullable = false)
    @Id
    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    @Column(name = "visitid", nullable = false)
    @Id
    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
    }

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitPK visitPK = (VisitPK) o;

        if (zoneid != visitPK.zoneid) return false;
        if (visitid != visitPK.visitid) return false;
        if (userid != visitPK.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zoneid;
        result = 31 * result + visitid;
        result = 31 * result + userid;
        return result;
    }
}
