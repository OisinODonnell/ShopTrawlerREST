package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", schema = "shoptrawler")
public class User extends BaseEntity {
    private int userid;
    private String emailAddress;
    private String firstname;
    private String gender;
    private String password;
    private String phone;
    private String surname;
    private String type;
    private Integer yob;
    private Collection<BonusCode> bonuscodesByUserid;
    private Collection<Favourite> favouritesByUserid;
    private Collection<Rating> ratingsByUserid;
    private Collection<Retailer> retailersByUserid;
    private Collection<ShoppingCentre> shoppingCentresByUserid;
    private Collection<UserPoint> userpointsByUserid;
    private Collection<Visit> visitsByUserid;

    public User() {
    }

    public User(List<String> attributes) {
        this.userid                     = toInteger( attributes.get(0));
        this.surname                    = attributes.get(1);
        this.firstname                  = attributes.get(2);
        this.emailAddress               = attributes.get(3);
        this.type                       = attributes.get(4);
        this.phone                      = attributes.get(5);
        this.password                   = attributes.get(6);
        this.yob                        = toInteger( attributes.get(7));
        this.gender                     = attributes.get(8);

    }
    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "yob")
    public Integer getYob() {
        return yob;
    }

    public void setYob(Integer yob) {
        this.yob = yob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (emailAddress != null ? !emailAddress.equals(user.emailAddress) : user.emailAddress != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (yob != null ? !yob.equals(user.yob) : user.yob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (yob != null ? yob.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<BonusCode> getBonuscodesByUserid() {
        return bonuscodesByUserid;
    }

    public void setBonuscodesByUserid(Collection<BonusCode> bonuscodesByUserid) {
        this.bonuscodesByUserid = bonuscodesByUserid;
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<Favourite> getFavouritesByUserid() {
        return favouritesByUserid;
    }

    public void setFavouritesByUserid(Collection<Favourite> favouritesByUserid) {
        this.favouritesByUserid = favouritesByUserid;
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<Rating> getRatingsByUserid() {
        return ratingsByUserid;
    }

    public void setRatingsByUserid(Collection<Rating> ratingsByUserid) {
        this.ratingsByUserid = ratingsByUserid;
    }

    @OneToMany(mappedBy = "usersByManagerid")
    public Collection<Retailer> getRetailersByUserid() {
        return retailersByUserid;
    }

    public void setRetailersByUserid(Collection<Retailer> retailersByUserid) {
        this.retailersByUserid = retailersByUserid;
    }

    @OneToMany(mappedBy = "usersByAdminid")
    public Collection<ShoppingCentre> getShoppingCentresByUserid() {
        return shoppingCentresByUserid;
    }

    public void setShoppingCentresByUserid(Collection<ShoppingCentre> shoppingCentresByUserid) {
        this.shoppingCentresByUserid = shoppingCentresByUserid;
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<UserPoint> getUserpointsByUserid() {
        return userpointsByUserid;
    }

    public void setUserpointsByUserid(Collection<UserPoint> userpointsByUserid) {
        this.userpointsByUserid = userpointsByUserid;
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<Visit> getVisitsByUserid() {
        return visitsByUserid;
    }

    public void setVisitsByUserid(Collection<Visit> visitsByUserid) {
        this.visitsByUserid = visitsByUserid;
    }
}
