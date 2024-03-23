package com.ho.study.unit.testing.changeemail.example7_2;

import java.util.List;

import com.ho.study.unit.testing.changeemail.example7_2.User2.UserType;

/**
 * 험블 컨트롤러
 * 핵사고날 아키텍처 분류상 애플리케이션 서비스
 */
public class UserController {
    
    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(Integer userId, String newEmail) {
        
        List<Object> data = database.getUserById(userId);
        String email = (String) data.get(1);
        UserType userType = (UserType) data.get(2);
        User2 user = new User2(userId, email, userType);

        List<Object> companyData = database.getCompany();
        String companyDomainName = (String) companyData.get(0);
        Integer numberOfEmployees = (Integer) companyData.get(1);

        Integer newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);

        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
