package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "locations", schema = "shoptrawler")
public class Location extends BaseEntity {
    private int locationid;
    private Integer altitude;
    private int gpsLatitude;
    private int gpsLongitude;
    private int locationInShoppingCentre;
    private String locationType;
    private Integer shoppingCentreid;
    private Collection<Beacon> beaconsByLocationid;
    private ShoppingCentre shoppingCentreByShoppingCentreid;

    public Location() {
    }

    public Location(List<String> attributes) {
        this.locationid                         = toInteger(attributes.get(0));
        this.gpsLatitude                        = toInteger(attributes.get(0));
        this.gpsLongitude                       = toInteger(attributes.get(0));
        this.locationInShoppingCentre           = toInteger(attributes.get(0));
        this.locationType                       = attributes.get(4);
        this.altitude                           = toInteger(attributes.get(0));
        this.shoppingCentreid                   = toInteger(attributes.get(0));

    }
    @Id
    @Column(name = "locationid")
    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "altitude")
    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    @Basic
    @Column(name = "gps_latitude")
    public int getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(int gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    @Basic
    @Column(name = "gps_longitude")
    public int getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(int gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    @Basic
    @Column(name = "location_in_shopping_centre")
    public int getLocationInShoppingCentre() {
        return locationInShoppingCentre;
    }

    public void setLocationInShoppingCentre(int locationInShoppingCentre) {
        this.locationInShoppingCentre = locationInShoppingCentre;
    }

    @Basic
    @Column(name = "location_type")
    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @Basic
    @Column(name = "shopping_centreid")
    public Integer getShoppingCentreid() {
        return shoppingCentreid;
    }

    public void setShoppingCentreid(Integer shoppingCentreid) {
        this.shoppingCentreid = shoppingCentreid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationid != location.locationid) return false;
        if (gpsLatitude != location.gpsLatitude) return false;
        if (gpsLongitude != location.gpsLongitude) return false;
        if (locationInShoppingCentre != location.locationInShoppingCentre) return false;
        if (altitude != null ? !altitude.equals(location.altitude) : location.altitude != null) return false;
        if (locationType != null ? !locationType.equals(location.locationType) : location.locationType != null)
            return false;
        if (shoppingCentreid != null ? !shoppingCentreid.equals(location.shoppingCentreid) : location.shoppingCentreid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationid;
        result = 31 * result + (altitude != null ? altitude.hashCode() : 0);
        result = 31 * result + gpsLatitude;
        result = 31 * result + gpsLongitude;
        result = 31 * result + locationInShoppingCentre;
        result = 31 * result + (locationType != null ? locationType.hashCode() : 0);
        result = 31 * result + (shoppingCentreid != null ? shoppingCentreid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationsByLocationid")
    public Collection<Beacon> getBeaconsByLocationid() {
        return beaconsByLocationid;
    }

    public void setBeaconsByLocationid(Collection<Beacon> beaconsByLocationid) {
        this.beaconsByLocationid = beaconsByLocationid;
    }

    @ManyToOne
    @JoinColumn(name = "shopping_centreid", referencedColumnName = "shopping_centreid",insertable = false, updatable = false)
    public ShoppingCentre getShoppingCentreByShoppingCentreid() {
        return shoppingCentreByShoppingCentreid;
    }

    public void setShoppingCentreByShoppingCentreid(ShoppingCentre shoppingCentreByShoppingCentreid) {
        this.shoppingCentreByShoppingCentreid = shoppingCentreByShoppingCentreid;
    }
}
