package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ZonePK implements Serializable {
    private int zoneid;
    private int beaconid;

    @Column(name = "zoneid", nullable = false)
    @Id
    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    @Column(name = "beaconid", nullable = false)
    @Id
    public int getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(int beaconid) {
        this.beaconid = beaconid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZonePK zonePK = (ZonePK) o;

        if (zoneid != zonePK.zoneid) return false;
        if (beaconid != zonePK.beaconid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zoneid;
        result = 31 * result + beaconid;
        return result;
    }
}
