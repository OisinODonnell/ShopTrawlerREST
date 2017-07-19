package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "zones", schema = "shoptrawler")
public class Zone {
    private int zoneId;
    private Integer beaconId;
    private String zoneName;
    private Integer retailerId;
    private Collection<Retailer> retailersByZoneId;
    private Beacon beaconsByBeaconId;
    private Retailer retailersByRetailerId;

    public Zone() {
    }

    public Zone(List<String> attributes) {
        this.zoneId = zoneId;
        this.beaconId = beaconId;
        this.zoneName = zoneName;
        this.retailerId = retailerId;
        this.retailersByZoneId = retailersByZoneId;
        this.beaconsByBeaconId = beaconsByBeaconId;
        this.retailersByRetailerId = retailersByRetailerId;
    }

    @Id
    @Column(name = "zoneID", nullable = false)
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "beaconID", nullable = true)
    public Integer getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(Integer beaconId) {
        this.beaconId = beaconId;
    }

    @Basic
    @Column(name = "zoneName", nullable = true, length = 45)
    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Basic
    @Column(name = "retailerID", nullable = true)
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

    @OneToMany(mappedBy = "zonesByZoneId")
    public Collection<Retailer> getRetailersByZoneId() {
        return retailersByZoneId;
    }

    public void setRetailersByZoneId(Collection<Retailer> retailersByZoneId) {
        this.retailersByZoneId = retailersByZoneId;
    }

    @ManyToOne
    @JoinColumn(name = "beaconID", referencedColumnName = "beaconID", insertable = false, updatable = false)
    public Beacon getBeaconsByBeaconId() {
        return beaconsByBeaconId;
    }

    public void setBeaconsByBeaconId(Beacon beaconsByBeaconId) {
        this.beaconsByBeaconId = beaconsByBeaconId;
    }

    @ManyToOne
    @JoinColumn(name = "retailerID", referencedColumnName = "retailerID", insertable = false, updatable = false)
    public Retailer getRetailersByRetailerId() {
        return retailersByRetailerId;
    }

    public void setRetailersByRetailerId(Retailer retailersByRetailerId) {
        this.retailersByRetailerId = retailersByRetailerId;
    }
}
