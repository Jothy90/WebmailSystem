package com.kash.mail.repository.model;

/**
 * Created with IntelliJ IDEA.
 * User: 123
 * Date: 6/7/15
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserProfile {
    String firstName;
    String lastName;
    String address;
    String birthday;
    boolean isMale;
    String mobileNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
