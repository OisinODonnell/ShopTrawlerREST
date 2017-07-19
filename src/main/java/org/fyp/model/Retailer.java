package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "retailers", schema = "shoptrawler")
public class Retailer extends BaseEntity {
    private int retailerId;
    private String storeName;
    private int managerId;
    private String phone;
    private int zoneId;
    private int shoppingCentreId;
    private String websiteUrl;
    private String twitterUrl;
    private String facebookUrl;
    private String headerBackgroundImage;
    private String defaultContentPage1;
    private String defaultContentPage2;
    private String defaultContentPage3;
    private String defaultLoyaltyRewardImage;
    private String logoImageSmall;
    private String logoImageMedium;
    private String logoImageLarge;
    private User usersByManagerId;
    private Zone zonesByZoneId;
    private ShoppingCentre shoppingcentreByShoppingCentreId;
    private Collection<Zone> zonesByRetailerId;

    public Retailer() {
    }

    public Retailer(List<String> attributes) {
        this.retailerId                         = toInteger( attributes.get(0));
        this.storeName                          = attributes.get(1);
        this.managerId                          = toInteger( attributes.get(2));
        this.phone                              = attributes.get(3);
        this.zoneId                             = toInteger( attributes.get(4));
        this.shoppingCentreId                   = toInteger( attributes.get(5));
        this.websiteUrl                         = attributes.get(6);
        this.twitterUrl                         = attributes.get(7);
        this.facebookUrl                        = attributes.get(8);
        this.headerBackgroundImage              = attributes.get(9);
        this.defaultContentPage1                = attributes.get(10);
        this.defaultContentPage2                = attributes.get(11);
        this.defaultContentPage3                = attributes.get(12);
        this.defaultLoyaltyRewardImage          = attributes.get(13);
        this.logoImageSmall                     = attributes.get(14);
        this.logoImageMedium                    = attributes.get(15);
        this.logoImageLarge                     = attributes.get(16);
    }

    @Id
    @Column(name = "retailerID", nullable = false)
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Basic
    @Column(name = "storeName", nullable = true, length = 45)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "managerID", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "zoneID", nullable = false)
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "shoppingCentreID", nullable = false)
    public int getShoppingCentreId() {
        return shoppingCentreId;
    }

    public void setShoppingCentreId(int shoppingCentreId) {
        this.shoppingCentreId = shoppingCentreId;
    }

    @Basic
    @Column(name = "websiteURL", nullable = true, length = 45)
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Basic
    @Column(name = "twitterURL", nullable = true, length = 45)
    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    @Basic
    @Column(name = "facebookURL", nullable = true, length = 45)
    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    @Basic
    @Column(name = "headerBackgroundImage", nullable = true, length = 45)
    public String getHeaderBackgroundImage() {
        return headerBackgroundImage;
    }

    public void setHeaderBackgroundImage(String headerBackgroundImage) {
        this.headerBackgroundImage = headerBackgroundImage;
    }

    @Basic
    @Column(name = "defaultContentPage1", nullable = true, length = 45)
    public String getDefaultContentPage1() {
        return defaultContentPage1;
    }

    public void setDefaultContentPage1(String defaultContentPage1) {
        this.defaultContentPage1 = defaultContentPage1;
    }

    @Basic
    @Column(name = "defaultContentPage2", nullable = true, length = 45)
    public String getDefaultContentPage2() {
        return defaultContentPage2;
    }

    public void setDefaultContentPage2(String defaultContentPage2) {
        this.defaultContentPage2 = defaultContentPage2;
    }

    @Basic
    @Column(name = "defaultContentPage3", nullable = true, length = 45)
    public String getDefaultContentPage3() {
        return defaultContentPage3;
    }

    public void setDefaultContentPage3(String defaultContentPage3) {
        this.defaultContentPage3 = defaultContentPage3;
    }

    @Basic
    @Column(name = "defaultLoyaltyRewardImage", nullable = true, length = 45)
    public String getDefaultLoyaltyRewardImage() {
        return defaultLoyaltyRewardImage;
    }

    public void setDefaultLoyaltyRewardImage(String defaultLoyaltyRewardImage) {
        this.defaultLoyaltyRewardImage = defaultLoyaltyRewardImage;
    }

    @Basic
    @Column(name = "logoImageSmall", nullable = true, length = 45)
    public String getLogoImageSmall() {
        return logoImageSmall;
    }

    public void setLogoImageSmall(String logoImageSmall) {
        this.logoImageSmall = logoImageSmall;
    }

    @Basic
    @Column(name = "logoImageMedium", nullable = true, length = 45)
    public String getLogoImageMedium() {
        return logoImageMedium;
    }

    public void setLogoImageMedium(String logoImageMedium) {
        this.logoImageMedium = logoImageMedium;
    }

    @Basic
    @Column(name = "logoImageLarge", nullable = true, length = 45)
    public String getLogoImageLarge() {
        return logoImageLarge;
    }

    public void setLogoImageLarge(String logoImageLarge) {
        this.logoImageLarge = logoImageLarge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Retailer retailer = (Retailer) o;

        if (retailerId != retailer.retailerId) return false;
        if (managerId != retailer.managerId) return false;
        if (zoneId != retailer.zoneId) return false;
        if (shoppingCentreId != retailer.shoppingCentreId) return false;
        if (storeName != null ? !storeName.equals(retailer.storeName) : retailer.storeName != null) return false;
        if (phone != null ? !phone.equals(retailer.phone) : retailer.phone != null) return false;
        if (websiteUrl != null ? !websiteUrl.equals(retailer.websiteUrl) : retailer.websiteUrl != null) return false;
        if (twitterUrl != null ? !twitterUrl.equals(retailer.twitterUrl) : retailer.twitterUrl != null) return false;
        if (facebookUrl != null ? !facebookUrl.equals(retailer.facebookUrl) : retailer.facebookUrl != null)
            return false;
        if (headerBackgroundImage != null ? !headerBackgroundImage.equals(retailer.headerBackgroundImage) : retailer.headerBackgroundImage != null)
            return false;
        if (defaultContentPage1 != null ? !defaultContentPage1.equals(retailer.defaultContentPage1) : retailer.defaultContentPage1 != null)
            return false;
        if (defaultContentPage2 != null ? !defaultContentPage2.equals(retailer.defaultContentPage2) : retailer.defaultContentPage2 != null)
            return false;
        if (defaultContentPage3 != null ? !defaultContentPage3.equals(retailer.defaultContentPage3) : retailer.defaultContentPage3 != null)
            return false;
        if (defaultLoyaltyRewardImage != null ? !defaultLoyaltyRewardImage.equals(retailer.defaultLoyaltyRewardImage) : retailer.defaultLoyaltyRewardImage != null)
            return false;
        if (logoImageSmall != null ? !logoImageSmall.equals(retailer.logoImageSmall) : retailer.logoImageSmall != null)
            return false;
        if (logoImageMedium != null ? !logoImageMedium.equals(retailer.logoImageMedium) : retailer.logoImageMedium != null)
            return false;
        if (logoImageLarge != null ? !logoImageLarge.equals(retailer.logoImageLarge) : retailer.logoImageLarge != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerId;
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + managerId;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + zoneId;
        result = 31 * result + shoppingCentreId;
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        result = 31 * result + (twitterUrl != null ? twitterUrl.hashCode() : 0);
        result = 31 * result + (facebookUrl != null ? facebookUrl.hashCode() : 0);
        result = 31 * result + (headerBackgroundImage != null ? headerBackgroundImage.hashCode() : 0);
        result = 31 * result + (defaultContentPage1 != null ? defaultContentPage1.hashCode() : 0);
        result = 31 * result + (defaultContentPage2 != null ? defaultContentPage2.hashCode() : 0);
        result = 31 * result + (defaultContentPage3 != null ? defaultContentPage3.hashCode() : 0);
        result = 31 * result + (defaultLoyaltyRewardImage != null ? defaultLoyaltyRewardImage.hashCode() : 0);
        result = 31 * result + (logoImageSmall != null ? logoImageSmall.hashCode() : 0);
        result = 31 * result + (logoImageMedium != null ? logoImageMedium.hashCode() : 0);
        result = 31 * result + (logoImageLarge != null ? logoImageLarge.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "managerID", referencedColumnName = "userID", nullable = false, insertable = false, updatable = false)
    public User getUsersByManagerId() {
        return usersByManagerId;
    }

    public void setUsersByManagerId(User usersByManagerId) {
        this.usersByManagerId = usersByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "zoneID", referencedColumnName = "zoneID", nullable = false, insertable = false, updatable = false)
    public Zone getZonesByZoneId() {
        return zonesByZoneId;
    }

    public void setZonesByZoneId(Zone zonesByZoneId) {
        this.zonesByZoneId = zonesByZoneId;
    }

    @ManyToOne
    @JoinColumn(name = "shoppingCentreID", referencedColumnName = "shoppingCentreID", nullable = false, insertable = false, updatable = false)
    public ShoppingCentre getShoppingcentreByShoppingCentreId() {
        return shoppingcentreByShoppingCentreId;
    }

    public void setShoppingcentreByShoppingCentreId(ShoppingCentre shoppingcentreByShoppingCentreId) {
        this.shoppingcentreByShoppingCentreId = shoppingcentreByShoppingCentreId;
    }

    @OneToMany(mappedBy = "retailersByRetailerId")
    public Collection<Zone> getZonesByRetailerId() {
        return zonesByRetailerId;
    }

    public void setZonesByRetailerId(Collection<Zone> zonesByRetailerId) {
        this.zonesByRetailerId = zonesByRetailerId;
    }
}
