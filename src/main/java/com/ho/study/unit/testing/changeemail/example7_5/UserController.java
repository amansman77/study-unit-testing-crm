package com.ho.study.unit.testing.changeemail.example7_5;

import java.util.List;

/**
 * 험블 컨트롤러
 * 핵사고날 아키텍처 분류상 애플리케이션 서비스
 */
public class UserController {
    
    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(Integer userId, String newEmail) {
        
        List<Object> userData = database.getUserById(userId);
        User5 user = UserFactory.create(userData);

        List<Object> companyData = database.getCompany();
        Company company = CompanyFactory.create(companyData);

        Company afterCompany = user.changeEmail(newEmail, company);

        database.saveCompany(afterCompany);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
