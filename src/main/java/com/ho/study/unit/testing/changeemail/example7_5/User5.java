package com.ho.study.unit.testing.changeemail.example7_5;

import java.util.List;

public class User5 {
    
    enum UserType {
        CUSTOMER, EMPLOYEE
    }

    private Integer userId;
    private String email;
    private UserType userType;

    public User5() {
    }

    public User5(Integer userId, String email, UserType userType) {
        this.userId = userId;
        this.email = email;
        this.userType = userType;
    }

    public Integer getUserId() {
        return this.userId;
    }
    public String getEmail() {
        return this.email;
    }

    public Company changeEmail(String newEmail, Company company) {
        
        if (this.email.equals(newEmail)) {
            return company;
        }

        boolean isEmailCorporate = company.isEmailCorporate(newEmail);
        UserType newType = isEmailCorporate? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (this.userType != newType) {
            Integer delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEMployees(delta);
        }

        this.email = newEmail;
        this.userType = newType;

        return company;
    }

    public List<Object> toList() {
        return List.of(this.userId, this.email, this.userType);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((userType == null) ? 0 : userType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User5 other = (User5) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return userType == other.userType;
    }

    
}
