package com.ho.study.unit.testing.changeemail.example7_3;

import java.util.List;

/**
 * 험블 컨트롤러
 * 핵사고날 아키텍처 분류상 애플리케이션 서비스
 */
public class UserController {
    
    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(Integer userId, String newEmail) {
        
        List<Object> data = database.getUserById(userId);
        User3 user = UserFactory.create(data);

        List<Object> companyData = database.getCompany();
        String companyDomainName = (String) companyData.get(0);
        Integer numberOfEmployees = (Integer) companyData.get(1);

        Integer newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);

        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
