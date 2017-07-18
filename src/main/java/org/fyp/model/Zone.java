package org.fyp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "zones", schema = "shoptrawler", catalog = "")
public class Zone {
    private int zoneId;
    private Integer beaconId;
    private String zoneName;
    private Integer retailerId;

    public Zone() {

    }

    public Zone(List<String> attributes) {


    }

    @Id
    @Column(name = "zoneID")
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "beaconID")
    public Integer getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(Integer beaconId) {
        this.beaconId = beaconId;
    }

    @Basic
    @Column(name = "zoneName")
    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Basic
    @Column(name = "retailerID")
    public Integer getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Integer retailerId) {
        this.retailerId = retailerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zone zone = (Zone) o;

        if (zoneId != zone.zoneId) return false;
        if (beaconId != null ? !beaconId.equals(zone.beaconId) : zone.beaconId != null) return false;
        if (zoneName != null ? !zoneName.equals(zone.zoneName) : zone.zoneName != null) return false;
        if (retailerId != null ? !retailerId.equals(zone.retailerId) : zone.retailerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zoneId;
        result = 31 * result + (beaconId != null ? beaconId.hashCode() : 0);
        result = 31 * result + (zoneName != null ? zoneName.hashCode() : 0);
        result = 31 * result + (retailerId != null ? retailerId.hashCode() : 0);
        return result;
    }
}
