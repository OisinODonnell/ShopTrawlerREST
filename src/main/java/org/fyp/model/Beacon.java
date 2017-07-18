package org.fyp.model;

import javax.persistence.*;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "beacons", schema = "shoptrawler", catalog = "")
public class Beacon {
    private int beaconId;
    private String uuid;
    private Integer major;
    private Integer Location;
    private Integer transmitPower;
    private int locationId;

    @Id
    @Column(name = "beaconID")
    public int getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "major")
    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Basic
    @Column(name = "minor")
    public Integer getLocation() {
        return Location;
    }

    public void setLocation(Integer location) {
        Location = location;
    }

    @Basic
    @Column(name = "transmitPower")
    public Integer getTransmitPower() {
        return transmitPower;
    }

    public void setTransmitPower(Integer transmitPower) {
        this.transmitPower = transmitPower;
    }

    @Basic
    @Column(name = "locationID")
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beacon beacon = (Beacon) o;

        if (beaconId != beacon.beaconId) return false;
        if (locationId != beacon.locationId) return false;
        if (uuid != null ? !uuid.equals(beacon.uuid) : beacon.uuid != null) return false;
        if (major != null ? !major.equals(beacon.major) : beacon.major != null) return false;
        if (Location != null ? !Location.equals(beacon.Location) : beacon.Location != null) return false;
        if (transmitPower != null ? !transmitPower.equals(beacon.transmitPower) : beacon.transmitPower != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beaconId;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (Location != null ? Location.hashCode() : 0);
        result = 31 * result + (transmitPower != null ? transmitPower.hashCode() : 0);
        result = 31 * result + locationId;
        return result;
    }
}
