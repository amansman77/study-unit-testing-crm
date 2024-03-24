package com.ho.study.unit.testing.changeemail.example7_4;

import java.util.List;

import com.ho.study.unit.testing.changeemail.example7_4.User4.UserType;

public class UserFactory {
    
    private UserFactory() {}
    
    public static User4 create(List<Object> data) {
        
        Precondition.requires(data.size() >= 3);

        Integer id = (Integer) data.get(0);
        String email = (String) data.get(1);
        UserType userType = (UserType) data.get(2);

        return new User4(id, email, userType);
    }
}
