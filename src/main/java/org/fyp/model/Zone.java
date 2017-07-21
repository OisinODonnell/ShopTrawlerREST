package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "zones", schema = "shoptrawler")
public class Zone extends BaseEntity {
    private int zoneid;
    private Integer beaconid;
    private Integer retailerid;
    private String zoneName;
    private Collection<Retailer> retailersByZoneid;
    private Collection<Visit> visitsByZoneid;
    private Beacon beaconsByBeaconid;
    private Retailer retailersByRetailerid;

    public Zone() {
    }

    public Zone(List<String> attributes) {
        this.zoneid             = toInteger(attributes.get(0));
        this.beaconid           = toInteger(attributes.get(1));
        this.zoneName           = attributes.get(2);
        this.retailerid         = toInteger(attributes.get(3));

    }
    @Id
    @Column(name = "zoneid")
    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    @Basic
    @Column(name = "beaconid")
    public Integer getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Integer beaconid) {
        this.beaconid = beaconid;
    }

    @Basic
    @Column(name = "retailerid")
    public Integer getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(Integer retailerid) {
        this.retailerid = retailerid;
    }

    @Basic
    @Column(name = "zone_name")
    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zone zone = (Zone) o;

        if (zoneid != zone.zoneid) return false;
        if (beaconid != null ? !beaconid.equals(zone.beaconid) : zone.beaconid != null) return false;
        if (retailerid != null ? !retailerid.equals(zone.retailerid) : zone.retailerid != null) return false;
        if (zoneName != null ? !zoneName.equals(zone.zoneName) : zone.zoneName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zoneid;
        result = 31 * result + (beaconid != null ? beaconid.hashCode() : 0);
        result = 31 * result + (retailerid != null ? retailerid.hashCode() : 0);
        result = 31 * result + (zoneName != null ? zoneName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "zonesByZoneid")
    public Collection<Retailer> getRetailersByZoneid() {
        return retailersByZoneid;
    }

    public void setRetailersByZoneid(Collection<Retailer> retailersByZoneid) {
        this.retailersByZoneid = retailersByZoneid;
    }

    @OneToMany(mappedBy = "zonesByZoneid")
    public Collection<Visit> getVisitsByZoneid() {
        return visitsByZoneid;
    }

    public void setVisitsByZoneid(Collection<Visit> visitsByZoneid) {
        this.visitsByZoneid = visitsByZoneid;
    }

    @ManyToOne
    @JoinColumn(name = "beaconid", referencedColumnName = "beaconid",insertable = false, updatable = false)
    public Beacon getBeaconsByBeaconid() {
        return beaconsByBeaconid;
    }

    public void setBeaconsByBeaconid(Beacon beaconsByBeaconid) {
        this.beaconsByBeaconid = beaconsByBeaconid;
    }

    @ManyToOne
    @JoinColumn(name = "retailerid", referencedColumnName = "retailerid",insertable = false, updatable = false)
    public Retailer getRetailersByRetailerid() {
        return retailersByRetailerid;
    }

    public void setRetailersByRetailerid(Retailer retailersByRetailerid) {
        this.retailersByRetailerid = retailersByRetailerid;
    }
}
