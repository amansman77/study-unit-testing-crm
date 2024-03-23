package com.ho.study.unit.testing.changeemail.example7_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ho.study.unit.testing.changeemail.example7_2.User2.UserType;

public class User2Test {

    @Test
    @DisplayName("사용자의 이메일을 변경합니다.")
    void testChangeEmail() {
    
        // given

        // when
        User2 user = new User2(1, "first@email.com", UserType.CUSTOMER);
        Integer numberOfEmployees = user.changeEmail("second@email.com", "company.com", 0);

        // then
        assertEquals(
            new User2(1, "second@email.com", UserType.CUSTOMER), 
            user,
            "사용자의 이메일만 변경됩니다."
        );

        assertEquals(0, numberOfEmployees, "사용자 이메일의 도메인이 기업 도메인과 다르면 고용자 수는 증가하지 않습니다.");
    }
}
