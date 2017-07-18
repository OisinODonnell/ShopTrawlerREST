package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Oisin on 7/18/2017.
 */
public class VisitPK implements Serializable {
    private int visitId;
    private int userId;
    private int zoneId;

    @Column(name = "visitID")
    @Id
    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    @Column(name = "userID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "zoneID")
    @Id
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitPK visitPK = (VisitPK) o;

        if (visitId != visitPK.visitId) return false;
        if (userId != visitPK.userId) return false;
        if (zoneId != visitPK.zoneId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitId;
        result = 31 * result + userId;
        result = 31 * result + zoneId;
        return result;
    }
}
