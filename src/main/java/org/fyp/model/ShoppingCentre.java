package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "shopping_centre", schema = "shoptrawler")
public class ShoppingCentre extends BaseEntity {
    private int shoppingCentreid;
    private Integer adminid;
    private String contentPage;
    private String facebookUrl;
    private String logoImageLarge;
    private String logoImageMedium;
    private String logoImageSmall;
    private String phone;
    private String shoppingCentreName;
    private String twitterUrl;
    private String websiteUrl;
    @JsonBackReference
    private Collection<Location> locationsByShoppingCentreid;
    @JsonBackReference
    private Collection<Retailer> retailersByShoppingCentreid;
    @JsonBackReference
    private User usersByAdminid;

    public ShoppingCentre() {
    }

    public ShoppingCentre(List<String> attributes) {

        this.shoppingCentreid               = toInteger( attributes.get(0));
        this.shoppingCentreName             = attributes.get(1);
        this.adminid                        = toInteger( attributes.get(2));
        this.websiteUrl                     = attributes.get(3);
        this.twitterUrl                     = attributes.get(4);
        this.facebookUrl                    = attributes.get(5);
        this.logoImageSmall                 = attributes.get(6);
        this.logoImageMedium                = attributes.get(7);
        this.logoImageLarge                 = attributes.get(8);
        this.phone                          = attributes.get(9);
        this.contentPage                    = attributes.get(10);

    }
    @Id
    @Column(name = "shopping_centreid", nullable = false)
    public int getShoppingCentreid() {
        return shoppingCentreid;
    }

    public void setShoppingCentreid(int shoppingCentreid) {
        this.shoppingCentreid = shoppingCentreid;
    }

    @Basic
    @Column(name = "adminid", nullable = true)
    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "content_page", nullable = true, length = 255)
    public String getContentPage() {
        return contentPage;
    }

    public void setContentPage(String contentPage) {
        this.contentPage = contentPage;
    }

    @Basic
    @Column(name = "facebookUrl", nullable = true, length = 255)
    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
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
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "shopping_centre_name", nullable = true, length = 255)
    public String getShoppingCentreName() {
        return shoppingCentreName;
    }

    public void setShoppingCentreName(String shoppingCentreName) {
        this.shoppingCentreName = shoppingCentreName;
    }

    @Basic
    @Column(name = "twitterUrl", nullable = true, length = 255)
    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    @Basic
    @Column(name = "websiteUrl", nullable = true, length = 255)
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCentre that = (ShoppingCentre) o;

        if (shoppingCentreid != that.shoppingCentreid) return false;
        if (adminid != null ? !adminid.equals(that.adminid) : that.adminid != null) return false;
        if (contentPage != null ? !contentPage.equals(that.contentPage) : that.contentPage != null) return false;
        if (facebookUrl != null ? !facebookUrl.equals(that.facebookUrl) : that.facebookUrl != null) return false;
        if (logoImageLarge != null ? !logoImageLarge.equals(that.logoImageLarge) : that.logoImageLarge != null)
            return false;
        if (logoImageMedium != null ? !logoImageMedium.equals(that.logoImageMedium) : that.logoImageMedium != null)
            return false;
        if (logoImageSmall != null ? !logoImageSmall.equals(that.logoImageSmall) : that.logoImageSmall != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (shoppingCentreName != null ? !shoppingCentreName.equals(that.shoppingCentreName) : that.shoppingCentreName != null)
            return false;
        if (twitterUrl != null ? !twitterUrl.equals(that.twitterUrl) : that.twitterUrl != null) return false;
        if (websiteUrl != null ? !websiteUrl.equals(that.websiteUrl) : that.websiteUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingCentreid;
        result = 31 * result + (adminid != null ? adminid.hashCode() : 0);
        result = 31 * result + (contentPage != null ? contentPage.hashCode() : 0);
        result = 31 * result + (facebookUrl != null ? facebookUrl.hashCode() : 0);
        result = 31 * result + (logoImageLarge != null ? logoImageLarge.hashCode() : 0);
        result = 31 * result + (logoImageMedium != null ? logoImageMedium.hashCode() : 0);
        result = 31 * result + (logoImageSmall != null ? logoImageSmall.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (shoppingCentreName != null ? shoppingCentreName.hashCode() : 0);
        result = 31 * result + (twitterUrl != null ? twitterUrl.hashCode() : 0);
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shoppingCentreByShoppingCentreid")
    public Collection<Location> getLocationsByShoppingCentreid() {
        return locationsByShoppingCentreid;
    }

    public void setLocationsByShoppingCentreid(Collection<Location> locationsByShoppingCentreid) {
        this.locationsByShoppingCentreid = locationsByShoppingCentreid;
    }

    @OneToMany(mappedBy = "shoppingCentreByShoppingCentreid")
    public Collection<Retailer> getRetailersByShoppingCentreid() {
        return retailersByShoppingCentreid;
    }

    public void setRetailersByShoppingCentreid(Collection<Retailer> retailersByShoppingCentreid) {
        this.retailersByShoppingCentreid = retailersByShoppingCentreid;
    }

    @ManyToOne
    @JoinColumn(name = "adminid", referencedColumnName = "userid",insertable = false, updatable = false)
    public User getUsersByAdminid() {
        return usersByAdminid;
    }

    public void setUsersByAdminid(User usersByAdminid) {
        this.usersByAdminid = usersByAdminid;
    }
}
