package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "retailers", schema = "shoptrawler")
public class Retailer extends BaseEntity {
    private int retailerid;
    private String defaultContentPage1;
    private String defaultContentPage2;
    private String defaultContentPage3;
    private String defaultLoyaltyRewardImage;
    private String facebookUrl;
    private String headerBackgroundImage;
    private String logoImageLarge;
    private String logoImageMedium;
    private String logoImageSmall;
    private Integer managerid;
    private String phone;
    private Integer shoppingCentreid;
    private String storeName;
    private String twitterUrl;
    private String websiteUrl;
    private Integer zoneid;

    @JsonManagedReference
    private Collection<BonusCode> bonuscodesByRetailerid;
    @JsonManagedReference
    private Collection<Content> contentsByRetailerid;
    @JsonManagedReference
    private Collection<Favourite> favouritesByRetailerid;
    @JsonManagedReference
    private Collection<LoyaltyReward> loyaltyrewardsByRetailerid;
    @JsonManagedReference
    private Collection<Rating> ratingsByRetailerid;
    @JsonManagedReference
    private User usersByManagerid;
    @JsonManagedReference
    private ShoppingCentre shoppingCentreByShoppingCentreid;
    // Jackson annotation probably needed here.
    @JsonManagedReference
    private Zone zonesByZoneid;
    @JsonManagedReference
    private Collection<UserPoint> userpointsByRetailerid;

    public Retailer() {
    }

    public Retailer(List<String> attributes) {
        this.retailerid                         = toInteger( attributes.get(0));
        this.storeName                          = attributes.get(1);
        this.managerid                          = toInteger( attributes.get(2));
        this.phone                              = attributes.get(3);
        this.zoneid                             = toInteger( attributes.get(4));
        this.shoppingCentreid                   = toInteger( attributes.get(5));
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
    @Column(name = "retailerid", nullable = false)
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Basic
    @Column(name = "default_content_page1", nullable = true, length = 255)
    public String getDefaultContentPage1() {
        return defaultContentPage1;
    }

    public void setDefaultContentPage1(String defaultContentPage1) {
        this.defaultContentPage1 = defaultContentPage1;
    }

    @Basic
    @Column(name = "default_content_page2", nullable = true, length = 255)
    public String getDefaultContentPage2() {
        return defaultContentPage2;
    }

    public void setDefaultContentPage2(String defaultContentPage2) {
        this.defaultContentPage2 = defaultContentPage2;
    }

    @Basic
    @Column(name = "default_content_page3", nullable = true, length = 255)
    public String getDefaultContentPage3() {
        return defaultContentPage3;
    }

    public void setDefaultContentPage3(String defaultContentPage3) {
        this.defaultContentPage3 = defaultContentPage3;
    }

    @Basic
    @Column(name = "default_loyalty_reward_image", nullable = true, length = 255)
    public String getDefaultLoyaltyRewardImage() {
        return defaultLoyaltyRewardImage;
    }

    public void setDefaultLoyaltyRewardImage(String defaultLoyaltyRewardImage) {
        this.defaultLoyaltyRewardImage = defaultLoyaltyRewardImage;
    }

    @Basic
    @Column(name = "facebook_url", nullable = true, length = 255)
    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    @Basic
    @Column(name = "header_background_image", nullable = true, length = 255)
    public String getHeaderBackgroundImage() {
        return headerBackgroundImage;
    }

    public void setHeaderBackgroundImage(String headerBackgroundImage) {
        this.headerBackgroundImage = headerBackgroundImage;
    }

    @Basic
    @Column(name = "logo_image_large", nullable = true, length = 255)
    public String getLogoImageLarge() {
        return logoImageLarge;
    }

    public void setLogoImageLarge(String logoImageLarge) {
        this.logoImageLarge = logoImageLarge;
    }

    @Basic
    @Column(name = "logo_image_medium", nullable = true, length = 255)
    public String getLogoImageMedium() {
        return logoImageMedium;
    }

    public void setLogoImageMedium(String logoImageMedium) {
        this.logoImageMedium = logoImageMedium;
    }

    @Basic
    @Column(name = "logo_image_small", nullable = true, length = 255)
    public String getLogoImageSmall() {
        return logoImageSmall;
    }

    public void setLogoImageSmall(String logoImageSmall) {
        this.logoImageSmall = logoImageSmall;
    }

    @Basic
    @Column(name = "managerid", nullable = true)
    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "shopping_centreid", nullable = true)
    public Integer getShoppingCentreid() {
        return shoppingCentreid;
    }

    public void setShoppingCentreid(Integer shoppingCentreid) {
        this.shoppingCentreid = shoppingCentreid;
    }

    @Basic
    @Column(name = "store_name", nullable = true, length = 255)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "twitter_url", nullable = true, length = 255)
    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    @Basic
    @Column(name = "website_url", nullable = true, length = 255)
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Basic
    @Column(name = "zoneid", nullable = true)
    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Retailer retailer = (Retailer) o;

        if (retailerid != retailer.retailerid) return false;
        if (defaultContentPage1 != null ? !defaultContentPage1.equals(retailer.defaultContentPage1) : retailer.defaultContentPage1 != null)
            return false;
        if (defaultContentPage2 != null ? !defaultContentPage2.equals(retailer.defaultContentPage2) : retailer.defaultContentPage2 != null)
            return false;
        if (defaultContentPage3 != null ? !defaultContentPage3.equals(retailer.defaultContentPage3) : retailer.defaultContentPage3 != null)
            return false;
        if (defaultLoyaltyRewardImage != null ? !defaultLoyaltyRewardImage.equals(retailer.defaultLoyaltyRewardImage) : retailer.defaultLoyaltyRewardImage != null)
            return false;
        if (facebookUrl != null ? !facebookUrl.equals(retailer.facebookUrl) : retailer.facebookUrl != null)
            return false;
        if (headerBackgroundImage != null ? !headerBackgroundImage.equals(retailer.headerBackgroundImage) : retailer.headerBackgroundImage != null)
            return false;
        if (logoImageLarge != null ? !logoImageLarge.equals(retailer.logoImageLarge) : retailer.logoImageLarge != null)
            return false;
        if (logoImageMedium != null ? !logoImageMedium.equals(retailer.logoImageMedium) : retailer.logoImageMedium != null)
            return false;
        if (logoImageSmall != null ? !logoImageSmall.equals(retailer.logoImageSmall) : retailer.logoImageSmall != null)
            return false;
        if (managerid != null ? !managerid.equals(retailer.managerid) : retailer.managerid != null) return false;
        if (phone != null ? !phone.equals(retailer.phone) : retailer.phone != null) return false;
        if (shoppingCentreid != null ? !shoppingCentreid.equals(retailer.shoppingCentreid) : retailer.shoppingCentreid != null)
            return false;
        if (storeName != null ? !storeName.equals(retailer.storeName) : retailer.storeName != null) return false;
        if (twitterUrl != null ? !twitterUrl.equals(retailer.twitterUrl) : retailer.twitterUrl != null) return false;
        if (websiteUrl != null ? !websiteUrl.equals(retailer.websiteUrl) : retailer.websiteUrl != null) return false;
        if (zoneid != null ? !zoneid.equals(retailer.zoneid) : retailer.zoneid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerid;
        result = 31 * result + (defaultContentPage1 != null ? defaultContentPage1.hashCode() : 0);
        result = 31 * result + (defaultContentPage2 != null ? defaultContentPage2.hashCode() : 0);
        result = 31 * result + (defaultContentPage3 != null ? defaultContentPage3.hashCode() : 0);
        result = 31 * result + (defaultLoyaltyRewardImage != null ? defaultLoyaltyRewardImage.hashCode() : 0);
        result = 31 * result + (facebookUrl != null ? facebookUrl.hashCode() : 0);
        result = 31 * result + (headerBackgroundImage != null ? headerBackgroundImage.hashCode() : 0);
        result = 31 * result + (logoImageLarge != null ? logoImageLarge.hashCode() : 0);
        result = 31 * result + (logoImageMedium != null ? logoImageMedium.hashCode() : 0);
        result = 31 * result + (logoImageSmall != null ? logoImageSmall.hashCode() : 0);
        result = 31 * result + (managerid != null ? managerid.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (shoppingCentreid != null ? shoppingCentreid.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (twitterUrl != null ? twitterUrl.hashCode() : 0);
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        result = 31 * result + (zoneid != null ? zoneid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<BonusCode> getBonuscodesByRetailerid() {
        return bonuscodesByRetailerid;
    }

    public void setBonuscodesByRetailerid(Collection<BonusCode> bonuscodesByRetailerid) {
        this.bonuscodesByRetailerid = bonuscodesByRetailerid;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<Content> getContentsByRetailerid() {
        return contentsByRetailerid;
    }

    public void setContentsByRetailerid(Collection<Content> contentsByRetailerid) {
        this.contentsByRetailerid = contentsByRetailerid;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<Favourite> getFavouritesByRetailerid() {
        return favouritesByRetailerid;
    }

    public void setFavouritesByRetailerid(Collection<Favourite> favouritesByRetailerid) {
        this.favouritesByRetailerid = favouritesByRetailerid;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<LoyaltyReward> getLoyaltyrewardsByRetailerid() {
        return loyaltyrewardsByRetailerid;
    }

    public void setLoyaltyrewardsByRetailerid(Collection<LoyaltyReward> loyaltyrewardsByRetailerid) {
        this.loyaltyrewardsByRetailerid = loyaltyrewardsByRetailerid;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<Rating> getRatingsByRetailerid() {
        return ratingsByRetailerid;
    }

    public void setRatingsByRetailerid(Collection<Rating> ratingsByRetailerid) {
        this.ratingsByRetailerid = ratingsByRetailerid;
    }

    @ManyToOne
    @JoinColumn(name = "managerid", referencedColumnName = "userid",insertable = false, updatable = false)
    public User getUsersByManagerid() {
        return usersByManagerid;
    }

    public void setUsersByManagerid(User usersByManagerid) {
        this.usersByManagerid = usersByManagerid;
    }

    @ManyToOne
    @JoinColumn(name = "shopping_centreid", referencedColumnName = "shopping_centreid",insertable = false, updatable = false)
    public ShoppingCentre getShoppingCentreByShoppingCentreid() {
        return shoppingCentreByShoppingCentreid;
    }

    public void setShoppingCentreByShoppingCentreid(ShoppingCentre shoppingCentreByShoppingCentreid) {
        this.shoppingCentreByShoppingCentreid = shoppingCentreByShoppingCentreid;
    }

    @ManyToOne
    @JoinColumn(name = "zoneid", referencedColumnName = "zoneid",insertable = false, updatable = false)
    public Zone getZonesByZoneid() {
        return zonesByZoneid;
    }

    public void setZonesByZoneid(Zone zonesByZoneid) {
        this.zonesByZoneid = zonesByZoneid;
    }

    @OneToMany(mappedBy = "retailersByRetailerid")
    public Collection<UserPoint> getUserpointsByRetailerid() {
        return userpointsByRetailerid;
    }

    public void setUserpointsByRetailerid(Collection<UserPoint> userpointsByRetailerid) {
        this.userpointsByRetailerid = userpointsByRetailerid;
    }
}
