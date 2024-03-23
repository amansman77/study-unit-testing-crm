package com.ho.study.unit.testing.changeemail.example7_1;

import java.util.List;

public class User {
    
    enum UserType {
        CUSTOMER, EMPLOYEE
    }

    public Integer userId;
    public String email;
    public UserType userType;

    public User() {
    }

    public User(Integer userId, String email, UserType userType) {
        this.userId = userId;
        this.email = email;
        this.userType = userType;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void changeEmail(Integer userId, String newEmail) {
        List<Object> data = Database.getUserById(userId);
        this.userId = userId;
        this.email = (String) data.get(1);
        this.userType = (UserType) data.get(2);

        if (this.email.equals(newEmail)) {
            return;
        }

        List<Object> companyData = Database.getCompany();
        String companyDomainName = (String) companyData.get(0);
        Integer numberOfEmployees = (Integer) companyData.get(1);

        String emailDomain = newEmail.split("@")[1];
        Boolean isEmailCorporate = emailDomain == companyDomainName;
        UserType newType = isEmailCorporate? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (this.userType == newType) {
            Integer delta = newType == UserType.EMPLOYEE? 1:-1;
            Integer newNumber = numberOfEmployees + delta;
            Database.saveCompany(newNumber);
        }

        this.email = newEmail;
        this.userType = newType;

        Database.saveUser(this);
        MessageBus.sendEmailChangedMessage(userId, newEmail);
    }

    public List<Object> toList() {
        return List.of(this.userId, this.email, this.userType);
    }
}
