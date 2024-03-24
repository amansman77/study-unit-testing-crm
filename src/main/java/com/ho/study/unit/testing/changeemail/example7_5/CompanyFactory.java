package com.ho.study.unit.testing.changeemail.example7_5;

import java.util.List;

public class CompanyFactory {

    public static Company create(List<Object> companyData) {

        Precondition.requires(companyData.size() >= 2);

        String companyDomainName = (String) companyData.get(0);
        Integer numberOfEmployees = (Integer) companyData.get(1);

        return new Company(companyDomainName, numberOfEmployees);
    }
}
