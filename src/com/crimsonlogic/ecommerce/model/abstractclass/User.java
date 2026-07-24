package com.crimsonlogic.ecommerce.model.abstractclass;

import java.util.Objects;

public abstract class User {
    private String userId;
    private String userName;
    private String email;
    private String mobileNumber;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public User(String userId, String userName, String email, String mobileNumber) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", email='" + email + '\'' + ", mobileNumber='" + mobileNumber + '\'' + '}';
    }
}
