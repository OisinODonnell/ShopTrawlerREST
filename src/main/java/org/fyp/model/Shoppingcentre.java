package org.fyp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
public class Shoppingcentre {
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

    @Id
    @Column(name = "shoppingCentreID")
    public int getShoppingCentreId() {
        return shoppingCentreId;
    }

    public void setShoppingCentreId(int shoppingCentreId) {
        this.shoppingCentreId = shoppingCentreId;
    }

    @Basic
    @Column(name = "shoppingCentreName")
    public String getShoppingCentreName() {
        return shoppingCentreName;
    }

    public void setShoppingCentreName(String shoppingCentreName) {
        this.shoppingCentreName = shoppingCentreName;
    }

    @Basic
    @Column(name = "adminID")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "websiteURL")
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Basic
    @Column(name = "twitterURL")
    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    @Basic
    @Column(name = "facebookURL")
    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    @Basic
    @Column(name = "logoImageSmall")
    public String getLogoImageSmall() {
        return logoImageSmall;
    }

    public void setLogoImageSmall(String logoImageSmall) {
        this.logoImageSmall = logoImageSmall;
    }

    @Basic
    @Column(name = "logoImageMedium")
    public String getLogoImageMedium() {
        return logoImageMedium;
    }

    public void setLogoImageMedium(String logoImageMedium) {
        this.logoImageMedium = logoImageMedium;
    }

    @Basic
    @Column(name = "logoImageLarge")
    public String getLogoImageLarge() {
        return logoImageLarge;
    }

    public void setLogoImageLarge(String logoImageLarge) {
        this.logoImageLarge = logoImageLarge;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "contentPage")
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

        Shoppingcentre that = (Shoppingcentre) o;

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
}
