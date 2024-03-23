package com.ho.study.unit.testing.changeemail.example7_3;

import java.util.List;

import com.ho.study.unit.testing.changeemail.example7_3.User3.UserType;

public class UserFactory {
    
    public static User3 create(List<Object> data) {
        
        Precondition.requires(data.size() >= 3);

        Integer id = (Integer) data.get(0);
        String email = (String) data.get(1);
        UserType userType = (UserType) data.get(2);

        return new User3(id, email, userType);
    }
}
