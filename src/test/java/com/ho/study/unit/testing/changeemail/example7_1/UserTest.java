package com.ho.study.unit.testing.changeemail.example7_1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ho.study.unit.testing.changeemail.example7_1.User.UserType;

public class UserTest {

    @Test
    @DisplayName("사용자의 이메일을 변경합니다.")
    void testChangeEmail() {
    
        // given
        Integer userId = 1;
        Database.saveUser(new User(1, "first@email.com", UserType.CUSTOMER));

        // when
        User user = new User();
        user.changeEmail(userId, "second@email.com");

        // then
        List<Object> findUserData = Database.getUserById(userId);
        assertAll("사용자의 이메일만 변경됩니다.", () -> {
            assertEquals(1, findUserData.get(0), "사용자 아이디는 다를 수 없습니다.");
            assertEquals("second@email.com", findUserData.get(1), "입력받은 이메일로 변경합니다.");
            assertEquals(UserType.CUSTOMER, findUserData.get(2), "도메인이 회사의 도메인과 다르면 손님입니다.");
        });
    }
}
