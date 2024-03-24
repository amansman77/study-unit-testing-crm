package com.ho.study.unit.testing.changeemail.example7_5;

import java.util.List;

import com.ho.study.unit.testing.changeemail.example7_5.User5.UserType;

public class UserFactory {
    
    private UserFactory() {}
    
    public static User5 create(List<Object> data) {
        
        Precondition.requires(data.size() >= 3);

        Integer id = (Integer) data.get(0);
        String email = (String) data.get(1);
        UserType userType = (UserType) data.get(2);

        return new User5(id, email, userType);
    }
}
