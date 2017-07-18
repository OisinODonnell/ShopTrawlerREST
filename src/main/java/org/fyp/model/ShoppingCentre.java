package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ShoppingCentre extends BaseEntity {
    private int shoppingCentreId;
    private String shoppingCentreName;
    private int adminId;
    private String websiteUrl;
    private String twitterUrl;
    private String facebookUrl;
    private String logoImageSmall;
    private String logoImageMedium;
    private String logoImageLarge;
    private String phone;
    private String contentPage;
    private Collection<Location> locationsByShoppingCentreId;
    private Collection<Retailer> retailersByShoppingCentreId;
    private User usersByAdminId;

    public ShoppingCentre() {
    }

    public ShoppingCentre(List<String> attributes) {

        this.shoppingCentreId               = toInteger( attributes.get(0));
        this.shoppingCentreName             = attributes.get(1);
        this.adminId                        = toInteger( attributes.get(2));
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
    @Column(name = "shoppingCentreID", nullable = false)
    public int getShoppingCentreId() {
        return shoppingCentreId;
    }

    public void setShoppingCentreId(int shoppingCentreId) {
        this.shoppingCentreId = shoppingCentreId;
    }

    @Basic
    @Column(name = "shoppingCentreName", nullable = true, length = 45)
    public String getShoppingCentreName() {
        return shoppingCentreName;
    }

    public void setShoppingCentreName(String shoppingCentreName) {
        this.shoppingCentreName = shoppingCentreName;
    }

    @Basic
    @Column(name = "adminID", nullable = false)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "contentPage", nullable = true, length = 45)
    public String getContentPage() {
        return contentPage;
    }

    public void setContentPage(String contentPage) {
        this.contentPage = contentPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCentre that = (ShoppingCentre) o;

        if (shoppingCentreId != that.shoppingCentreId) return false;
        if (adminId != that.adminId) return false;
        if (shoppingCentreName != null ? !shoppingCentreName.equals(that.shoppingCentreName) : that.shoppingCentreName != null)
            return false;
        if (websiteUrl != null ? !websiteUrl.equals(that.websiteUrl) : that.websiteUrl != null) return false;
        if (twitterUrl != null ? !twitterUrl.equals(that.twitterUrl) : that.twitterUrl != null) return false;
        if (facebookUrl != null ? !facebookUrl.equals(that.facebookUrl) : that.facebookUrl != null) return false;
        if (logoImageSmall != null ? !logoImageSmall.equals(that.logoImageSmall) : that.logoImageSmall != null)
            return false;
        if (logoImageMedium != null ? !logoImageMedium.equals(that.logoImageMedium) : that.logoImageMedium != null)
            return false;
        if (logoImageLarge != null ? !logoImageLarge.equals(that.logoImageLarge) : that.logoImageLarge != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (contentPage != null ? !contentPage.equals(that.contentPage) : that.contentPage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingCentreId;
        result = 31 * result + (shoppingCentreName != null ? shoppingCentreName.hashCode() : 0);
        result = 31 * result + adminId;
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        result = 31 * result + (twitterUrl != null ? twitterUrl.hashCode() : 0);
        result = 31 * result + (facebookUrl != null ? facebookUrl.hashCode() : 0);
        result = 31 * result + (logoImageSmall != null ? logoImageSmall.hashCode() : 0);
        result = 31 * result + (logoImageMedium != null ? logoImageMedium.hashCode() : 0);
        result = 31 * result + (logoImageLarge != null ? logoImageLarge.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (contentPage != null ? contentPage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shoppingcentreByShoppingCentreId")
    public Collection<Location> getLocationsByShoppingCentreId() {
        return locationsByShoppingCentreId;
    }

    public void setLocationsByShoppingCentreId(Collection<Location> locationsByShoppingCentreId) {
        this.locationsByShoppingCentreId = locationsByShoppingCentreId;
    }

    @OneToMany(mappedBy = "shoppingcentreByShoppingCentreId")
    public Collection<Retailer> getRetailersByShoppingCentreId() {
        return retailersByShoppingCentreId;
    }

    public void setRetailersByShoppingCentreId(Collection<Retailer> retailersByShoppingCentreId) {
        this.retailersByShoppingCentreId = retailersByShoppingCentreId;
    }

    @ManyToOne
    @JoinColumn(name = "adminID", referencedColumnName = "userID", nullable = false)
    public User getUsersByAdminId() {
        return usersByAdminId;
    }

    public void setUsersByAdminId(User usersByAdminId) {
        this.usersByAdminId = usersByAdminId;
    }
}
