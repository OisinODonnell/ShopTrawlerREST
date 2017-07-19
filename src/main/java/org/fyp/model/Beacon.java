package org.fyp.model;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "beacons", schema = "shoptrawler")
public class Beacon extends BaseEntity {
    private int beaconId;
    private String uuid;
    private Integer major;
    private Integer minor;
    private Integer transmitPower;
    private int locationId;
    private Location locationsByLocationId;
    private Collection<Zone> zonesByBeaconId;

    public Beacon() {
    }

    public Beacon(List<String> attributes) throws ParseException {
        this.beaconId               = toInteger(attributes.get(0));
        this.uuid                   = attributes.get(1);
        this.major                  = toInteger(attributes.get(2));
        this.minor                  = toInteger(attributes.get(3));
        this.transmitPower          = toInteger(attributes.get(4));
        this.locationId             = toInteger(attributes.get(5));
    }

    @Id
    @Column(name = "beaconID", nullable = false)
    public int getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }

    @Basic
    @Column(name = "uuid", nullable = false, length = 45)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "major", nullable = true)
    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Basic
    @Column(name = "minor", nullable = true)
    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    @Basic
    @Column(name = "transmitPower", nullable = true, precision = 0)
    public Integer getTransmitPower() {
        return transmitPower;
    }

    public void setTransmitPower(Integer transmitPower) {
        this.transmitPower = transmitPower;
    }

    @Basic
    @Column(name = "locationID", nullable = false)
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
        if (minor != null ? !minor.equals(beacon.minor) : beacon.minor != null) return false;
        if (transmitPower != null ? !transmitPower.equals(beacon.transmitPower) : beacon.transmitPower != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beaconId;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (transmitPower != null ? transmitPower.hashCode() : 0);
        result = 31 * result + locationId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "locationID", referencedColumnName = "locationID", nullable = false, insertable = false, updatable = false)
    public Location getLocationsByLocationId() {
        return locationsByLocationId;
    }

    public void setLocationsByLocationId(Location locationsByLocationId) {
        this.locationsByLocationId = locationsByLocationId;
    }

    @OneToMany(mappedBy = "beaconsByBeaconId")
    public Collection<Zone> getZonesByBeaconId() {
        return zonesByBeaconId;
    }

    public void setZonesByBeaconId(Collection<Zone> zonesByBeaconId) {
        this.zonesByBeaconId = zonesByBeaconId;
    }
}
