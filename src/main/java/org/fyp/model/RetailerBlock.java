package org.fyp.model;


public class RetailerBlock {

    // A problem occurred during late testing which meant null values for these fields were returned
    // if a loyalty reward scheme was not created for a given date.
    // rather than change the retailer/loyalty reward entities and associated jpa and mysql issues,
    // they were set here nor now
    private final int pointsPerVisit = 10;
    private final String rewardImage = "Reward Image";
    private final String rewardTitle = "Reward Title";
    private final int visitTime = 10;


    // Retailer
    private int     retailerid;
    private String  contentPage1;
    private String  contentPage2;
    private String  contentPage3;
    private String  loyaltyRewardImage;
    private String  facebookUrl;
    private String  headerBackgroundImage;
    private String  logoImage;
    private Integer managerid;
//    private String  storeManagersName;
    private String  phone;
    private Integer shoppingCentreid;
//    private String  shoppingCentreName;
    private String  storeName;
    private String  twitterUrl;
    private String  websiteUrl;
    private Integer zoneid;
//    private Integer userid;
    private String  usersFirstname;
    private String  usersSurname;

    // LoyaltyReward vars
    private Integer   lrPointsPerVisit;
    private String    lrImage;
    private String    lrTitle;
    private Integer   lrVisitTime;

    // UserPoint vars
    private Integer userPoints;

    public RetailerBlock( ) {
    }

    public void update( Retailer retailer) {
        // Retailer
        this.retailerid            = retailer.getRetailerid();
        this.storeName             = retailer.getStoreName       ();
        this.managerid             = retailer.getManagerid();
        this.phone                 = retailer.getPhone();
        this.zoneid                = retailer.getZoneid();
        this.shoppingCentreid      = retailer.getShoppingCentreid();
        this.websiteUrl            = retailer.getWebsiteUrl();
        this.twitterUrl            = retailer.getTwitterUrl();
        this.facebookUrl           = retailer.getFacebookUrl();
        this.headerBackgroundImage = retailer.getHeaderBackgroundImage();
        this.contentPage1          = retailer.getDefaultContentPage1      ();
        this.contentPage2          = retailer.getDefaultContentPage2      ();
        this.contentPage3          = retailer.getDefaultContentPage3      ();
        this.loyaltyRewardImage    = retailer.getDefaultLoyaltyRewardImage();
        this.logoImage             = retailer.getLogoImageSmall();
    }

    public void update( LoyaltyReward loyaltyReward ) {
        if (loyaltyReward != null) {
            this.lrPointsPerVisit = loyaltyReward.getPointsPerVisit();

            this.loyaltyRewardImage = loyaltyReward.getRewardImage();
            this.lrImage            = loyaltyReward.getRewardImage();
            this.lrTitle          = loyaltyReward.getRewardTitle();
            this.lrVisitTime      = loyaltyReward.getVisitTime();
        } else { // set hard coded defaults
            this.lrPointsPerVisit = pointsPerVisit;
            this.lrImage          = rewardImage;
            this.lrTitle          = rewardTitle;
            this.lrVisitTime      = visitTime;
        }
    }

    public void update(Content content) {
        if (content != null) {
            this.contentPage1 = content.getPage1();
            this.contentPage2 = content.getPage2();
            this.contentPage3 = content.getPage3();
        }
    }

    public void update(UserPoint userPoint) {
        if (userPoint != null) {
            this.userPoints = userPoint.getPoints( );
        } else { // default to zero if null
            this.userPoints = 0;
        }
    }


    public void update(User user) {
        this.usersFirstname = user.getFirstname();
        this.usersSurname = user.getSurname();
    }

    public int getRetailerid( ) {
        return retailerid;
    }

    public void setRetailerid( int retailerid ) {
        this.retailerid = retailerid;
    }

    public String getContentPage1( ) {
        return contentPage1;
    }

    public void setContentPage1( String contentPage1 ) {
        this.contentPage1 = contentPage1;
    }

    public String getContentPage2( ) {
        return contentPage2;
    }

    public void setContentPage2( String contentPage2 ) {
        this.contentPage2 = contentPage2;
    }

    public String getContentPage3( ) {
        return contentPage3;
    }

    public void setContentPage3( String contentPage3 ) {
        this.contentPage3 = contentPage3;
    }

    public String getLoyaltyRewardImage( ) {
        return loyaltyRewardImage;
    }

    public void setLoyaltyRewardImage( String loyaltyRewardImage ) {
        this.loyaltyRewardImage = loyaltyRewardImage;
    }

    public String getFacebookUrl( ) {
        return facebookUrl;
    }

    public void setFacebookUrl( String facebookUrl ) {
        this.facebookUrl = facebookUrl;
    }

    public String getHeaderBackgroundImage( ) {
        return headerBackgroundImage;
    }

    public void setHeaderBackgroundImage( String headerBackgroundImage ) {
        this.headerBackgroundImage = headerBackgroundImage;
    }

    public String getLogoImage( ) {
        return logoImage;
    }

    public void setLogoImage( String logoImage ) {
        this.logoImage = logoImage;
    }

    public Integer getManagerid( ) {
        return managerid;
    }

    public void setManagerid( Integer managerid ) {
        this.managerid = managerid;
    }

    public String getPhone( ) {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public Integer getShoppingCentreid( ) {
        return shoppingCentreid;
    }

    public void setShoppingCentreid( Integer shoppingCentreid ) {
        this.shoppingCentreid = shoppingCentreid;
    }

    public String getStoreName( ) {
        return storeName;
    }

    public void setStoreName( String storeName ) {
        this.storeName = storeName;
    }

    public String getTwitterUrl( ) {
        return twitterUrl;
    }

    public void setTwitterUrl( String twitterUrl ) {
        this.twitterUrl = twitterUrl;
    }

    public String getWebsiteUrl( ) {
        return websiteUrl;
    }

    public void setWebsiteUrl( String websiteUrl ) {
        this.websiteUrl = websiteUrl;
    }

    public Integer getZoneid( ) {
        return zoneid;
    }

    public void setZoneid( Integer zoneid ) {
        this.zoneid = zoneid;
    }

    public Integer getLrPointsPerVisit( ) {
        return lrPointsPerVisit;
    }

    public void setLrPointsPerVisit( Integer lrPointsPerVisit ) {
        this.lrPointsPerVisit = lrPointsPerVisit;
    }

    public String getLrImage( ) {
        return lrImage;
    }

    public void setLrImage( String lrImage ) {
        this.lrImage = lrImage;
    }

    public String getLrTitle( ) {
        return lrTitle;
    }

    public void setLrTitle( String lrTitle ) {
        this.lrTitle = lrTitle;
    }

    public Integer getLrVisitTime( ) {
        return lrVisitTime;
    }

    public void setLrVisitTime( Integer lrVisitTime ) {
        this.lrVisitTime = lrVisitTime;
    }

    public Integer getUserPoints( ) {
        return userPoints;
    }

    public void setUserPoints(Integer userPoints) {
        this.userPoints = userPoints;
    }

    public String getUsersFirstname() {
        return usersFirstname;
    }

    public void setUsersFirstname(String usersFirstname) {
        this.usersFirstname = usersFirstname;
    }

    public String getUsersSurname() {
        return usersSurname;
    }

    public void setUsersSurname(String usersSurname) {
        this.usersSurname = usersSurname;
    }
}
