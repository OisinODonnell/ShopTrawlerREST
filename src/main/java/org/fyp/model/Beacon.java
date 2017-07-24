package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "beacons", schema = "shoptrawler")
public class Beacon extends BaseEntity {
    private int beaconid;
    private Integer locationid;
    private Integer major;
    private Integer minor;
    private Integer transmitPower;
    private String uuid;
    @JsonManagedReference
    private Location locationsByLocationid;
    @JsonBackReference
    private Collection<Zone> zonesByBeaconid;

    public Beacon() {
    }

    public Beacon(List<String> attributes)  {
        this.beaconid               = toInteger(attributes.get(0));
        this.uuid                   = attributes.get(1);
        this.major                  = toInteger(attributes.get(2));
        this.minor                  = toInteger(attributes.get(3));
        this.transmitPower          = toInteger(attributes.get(4));
        this.locationid             = toInteger(attributes.get(5));
    }
    @Id
    @Column(name = "beaconid", nullable = false)
    public int getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(int beaconid) {
        this.beaconid = beaconid;
    }

    @Basic
    @Column(name = "locationid", nullable = true)
    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
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
    @Column(name = "transmit_power", nullable = true)
    public Integer getTransmitPower() {
        return transmitPower;
    }

    public void setTransmitPower(Integer transmitPower) {
        this.transmitPower = transmitPower;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 255)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beacon beacon = (Beacon) o;

        if (beaconid != beacon.beaconid) return false;
        if (locationid != null ? !locationid.equals(beacon.locationid) : beacon.locationid != null) return false;
        if (major != null ? !major.equals(beacon.major) : beacon.major != null) return false;
        if (minor != null ? !minor.equals(beacon.minor) : beacon.minor != null) return false;
        if (transmitPower != null ? !transmitPower.equals(beacon.transmitPower) : beacon.transmitPower != null)
            return false;
        if (uuid != null ? !uuid.equals(beacon.uuid) : beacon.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beaconid;
        result = 31 * result + (locationid != null ? locationid.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (transmitPower != null ? transmitPower.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "locationid", referencedColumnName = "locationid",insertable = false, updatable = false)
    public Location getLocationsByLocationid() {
        return locationsByLocationid;
    }

    public void setLocationsByLocationid(Location locationsByLocationid) {
        this.locationsByLocationid = locationsByLocationid;
    }

    @OneToMany(mappedBy = "beaconsByBeaconid")
    public Collection<Zone> getZonesByBeaconid() {
        return zonesByBeaconid;
    }

    public void setZonesByBeaconid(Collection<Zone> zonesByBeaconid) {
        this.zonesByBeaconid = zonesByBeaconid;
    }
}
