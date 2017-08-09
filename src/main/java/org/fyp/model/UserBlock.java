package org.fyp.model;


import java.sql.Timestamp;
import java.util.Collection;

public class UserBlock {

    private int                   userid;
    private String                emailAddress;
    private String                firstname;
    private String                gender;
    private String                password;
    private String                phone;
    private String                surname;
    private String                type;
    private Integer               yob;
    private Collection<BonusCode> bonuscodes;
    private Collection<Favourite> favourites;
    private Collection<UserPoint> userpoints;
    private Collection<Visit>     visits;

    // Visit vars
    private int       visitid;
    private Integer   duration;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private Integer   userCreditedForVisit;


    public UserBlock(Collection<BonusCode> bonusCodes, Collection<Favourite> favourites,
                     Collection<UserPoint> userPoints, Collection<Visit>     visits     ) {


    }

    public UserBlock( int userid, String emailAddress, String firstname, String gender, String password, String phone,
                      String surname, String type, Integer yob, Collection<BonusCode> bonuscodes,
                      Collection<Favourite> favourites, Collection<UserPoint> userpoints, Collection<Visit> visits ) {
        this.userid       = userid;
        this.emailAddress = emailAddress;
        this.firstname    = firstname;
        this.gender       = gender;
        this.password     = password;
        this.phone        = phone;
        this.surname      = surname;
        this.type         = type;
        this.yob          = yob;
        this.bonuscodes   = bonuscodes;
        this.favourites   = favourites;
        this.userpoints   = userpoints;
        this.visits       = visits;
    }


    public int getUserid( ) {
        return userid;
    }

    public void setUserid( int userid ) {
        this.userid = userid;
    }

    public String getEmailAddress( ) {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress ) {
        this.emailAddress = emailAddress;
    }

    public String getFirstname( ) {
        return firstname;
    }

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }

    public String getGender( ) {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public String getPassword( ) {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPhone( ) {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getSurname( ) {
        return surname;
    }

    public void setSurname( String surname ) {
        this.surname = surname;
    }

    public String getType( ) {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public Integer getYob( ) {
        return yob;
    }

    public void setYob( Integer yob ) {
        this.yob = yob;
    }

    public Collection<BonusCode> getBonuscodes( ) {
        return bonuscodes;
    }

    public void setBonuscodes( Collection<BonusCode> bonuscodes ) {
        this.bonuscodes = bonuscodes;
    }

    public Collection<Favourite> getFavourites( ) {
        return favourites;
    }

    public void setFavourites( Collection<Favourite> favourites ) {
        this.favourites = favourites;
    }

    public Collection<UserPoint> getUserpoints( ) {
        return userpoints;
    }

    public void setUserpoints( Collection<UserPoint> userpoints ) {
        this.userpoints = userpoints;
    }

    public Collection<Visit> getVisits( ) {
        return visits;
    }

    public void setVisits( Collection<Visit> visits ) {
        this.visits = visits;
    }


}
