package org.fyp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "shoptrawler", catalog = "")
public class User {
    private int userId;
    private String surname;
    private String firstname;
    private String emailAddress;
    private String type;
    private String phoneNumber;
    private String password;
    private Integer yob;
    private String gender;
    private Collection<Retailer> retailersByUserId;
    private Collection<ShoppingCentre> shoppingcentresByUserId;

    @Id
    @Column(name = "userID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "emailAddress", nullable = false, length = 45)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "YOB", nullable = true)
    public Integer getYob() {
        return yob;
    }

    public void setYob(Integer yob) {
        this.yob = yob;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (emailAddress != null ? !emailAddress.equals(user.emailAddress) : user.emailAddress != null) return false;
        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (yob != null ? !yob.equals(user.yob) : user.yob != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (yob != null ? yob.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByManagerId")
    public Collection<Retailer> getRetailersByUserId() {
        return retailersByUserId;
    }

    public void setRetailersByUserId(Collection<Retailer> retailersByUserId) {
        this.retailersByUserId = retailersByUserId;
    }

    @OneToMany(mappedBy = "usersByAdminId")
    public Collection<ShoppingCentre> getShoppingcentresByUserId() {
        return shoppingcentresByUserId;
    }

    public void setShoppingcentresByUserId(Collection<ShoppingCentre> shoppingcentresByUserId) {
        this.shoppingcentresByUserId = shoppingcentresByUserId;
    }
}
