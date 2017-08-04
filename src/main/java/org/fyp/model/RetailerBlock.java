package org.fyp.model;


public class RetailerBlock {

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



    public RetailerBlock() {
    }

    public RetailerBlock(Retailer retailer) {
        this.retailerid                         = retailer.getRetailerid();
        this.storeName                          = retailer.getStoreName();
        this.managerid                          = retailer.getManagerid();
        this.phone                              = retailer.getPhone();
        this.zoneid                             = retailer.getZoneid();
        this.shoppingCentreid                   = retailer.getShoppingCentreid();
        this.websiteUrl                         = retailer.getWebsiteUrl();
        this.twitterUrl                         = retailer.getTwitterUrl();
        this.facebookUrl                        = retailer.getFacebookUrl();
        this.headerBackgroundImage              = retailer.getHeaderBackgroundImage();
        this.defaultContentPage1                = retailer.getDefaultContentPage1();
        this.defaultContentPage2                = retailer.getDefaultContentPage2();
        this.defaultContentPage3                = retailer.getDefaultContentPage3();
        this.defaultLoyaltyRewardImage          = retailer.getDefaultLoyaltyRewardImage();
        this.logoImageSmall                     = retailer.getLogoImageSmall();
        this.logoImageMedium                    = retailer.getLogoImageMedium();
        this.logoImageLarge                     = retailer.getLogoImageLarge();
    }


    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    public String getDefaultContentPage1() {
        return defaultContentPage1;
    }

    public void setDefaultContentPage1(String defaultContentPage1) {
        this.defaultContentPage1 = defaultContentPage1;
    }

    public String getDefaultContentPage2() {
        return defaultContentPage2;
    }

    public void setDefaultContentPage2(String defaultContentPage2) {
        this.defaultContentPage2 = defaultContentPage2;
    }

    public String getDefaultContentPage3() {
        return defaultContentPage3;
    }

    public void setDefaultContentPage3(String defaultContentPage3) {
        this.defaultContentPage3 = defaultContentPage3;
    }

    public String getDefaultLoyaltyRewardImage() {
        return defaultLoyaltyRewardImage;
    }

    public void setDefaultLoyaltyRewardImage(String defaultLoyaltyRewardImage) {
        this.defaultLoyaltyRewardImage = defaultLoyaltyRewardImage;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getHeaderBackgroundImage() {
        return headerBackgroundImage;
    }

    public void setHeaderBackgroundImage(String headerBackgroundImage) {
        this.headerBackgroundImage = headerBackgroundImage;
    }

    public String getLogoImageLarge() {
        return logoImageLarge;
    }

    public void setLogoImageLarge(String logoImageLarge) {
        this.logoImageLarge = logoImageLarge;
    }

    public String getLogoImageMedium() {
        return logoImageMedium;
    }

    public void setLogoImageMedium(String logoImageMedium) {
        this.logoImageMedium = logoImageMedium;
    }

    public String getLogoImageSmall() {
        return logoImageSmall;
    }

    public void setLogoImageSmall(String logoImageSmall) {
        this.logoImageSmall = logoImageSmall;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getShoppingCentreid() {
        return shoppingCentreid;
    }

    public void setShoppingCentreid(Integer shoppingCentreid) {
        this.shoppingCentreid = shoppingCentreid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

}
