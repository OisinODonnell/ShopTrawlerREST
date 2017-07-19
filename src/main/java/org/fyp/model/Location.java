package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "locations", schema = "shoptrawler")
public class Location extends BaseEntity {
    private int locationId;
    private int gpsLatitude;
    private int gpsLongitude;
    private int locationInShoppingCentre;
    private String locationType;
    private Integer altitude;
    private Integer shoppingCentreId;
    private Collection<Beacon> beaconsByLocationId;
    private ShoppingCentre shoppingcentreByShoppingCentreId;

    public Location() {
    }

    public Location(List<String> attributes) {
        this.locationId                         = toInteger(attributes.get(0));
        this.gpsLatitude                        = toInteger(attributes.get(0));
        this.gpsLongitude                       = toInteger(attributes.get(0));
        this.locationInShoppingCentre           = toInteger(attributes.get(0));
        this.locationType                       = attributes.get(4);
        this.altitude                           = toInteger(attributes.get(0));
        this.shoppingCentreId                   = toInteger(attributes.get(0));

    }

    @Id
    @Column(name = "locationID", nullable = false)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "gpsLatitude", nullable = false, precision = 0)
    public int getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(int gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    @Basic
    @Column(name = "gpsLongitude", nullable = false, precision = 0)
    public int getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(int gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    @Basic
    @Column(name = "locationInShoppingCentre", nullable = false)
    public int getLocationInShoppingCentre() {
        return locationInShoppingCentre;
    }

    public void setLocationInShoppingCentre(int locationInShoppingCentre) {
        this.locationInShoppingCentre = locationInShoppingCentre;
    }

    @Basic
    @Column(name = "locationType", nullable = true)
    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @Basic
    @Column(name = "altitude", nullable = true, precision = 0)
    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    @Basic
    @Column(name = "shoppingCentreID", nullable = true)
    public Integer getShoppingCentreId() {
        return shoppingCentreId;
    }

    public void setShoppingCentreId(Integer shoppingCentreId) {
        this.shoppingCentreId = shoppingCentreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationId != location.locationId) return false;
        if (gpsLatitude != location.gpsLatitude) return false;
        if (gpsLongitude != location.gpsLongitude) return false;
        if (locationInShoppingCentre != location.locationInShoppingCentre) return false;
        if (locationType != null ? !locationType.equals(location.locationType) : location.locationType != null)
            return false;
        if (altitude != null ? !altitude.equals(location.altitude) : location.altitude != null) return false;
        if (shoppingCentreId != null ? !shoppingCentreId.equals(location.shoppingCentreId) : location.shoppingCentreId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId;
        result = 31 * result + gpsLatitude;
        result = 31 * result + gpsLongitude;
        result = 31 * result + locationInShoppingCentre;
        result = 31 * result + (locationType != null ? locationType.hashCode() : 0);
        result = 31 * result + (altitude != null ? altitude.hashCode() : 0);
        result = 31 * result + (shoppingCentreId != null ? shoppingCentreId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationsByLocationId")
    public Collection<Beacon> getBeaconsByLocationId() {
        return beaconsByLocationId;
    }

    public void setBeaconsByLocationId(Collection<Beacon> beaconsByLocationId) {
        this.beaconsByLocationId = beaconsByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "shoppingCentreID", referencedColumnName = "shoppingCentreID", insertable = false, updatable = false)
    public ShoppingCentre getShoppingcentreByShoppingCentreId() {
        return shoppingcentreByShoppingCentreId;
    }

    public void setShoppingcentreByShoppingCentreId(ShoppingCentre shoppingcentreByShoppingCentreId) {
        this.shoppingcentreByShoppingCentreId = shoppingcentreByShoppingCentreId;
    }
}
