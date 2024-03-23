package com.ho.study.unit.testing.changeemail.example7_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.ho.study.unit.testing.changeemail.example7_3.User3.UserType;

@DisplayName("사용자를 생성하는 팩토리 클래스입니다.")
public class UserFactoryTest {

    @Nested
    @DisplayName("리스트형 데이터로 사용자를 생성합니다.")
    class testCreate {

        @Test
        @DisplayName("리스트의 데이터 순서는 아이디, 이메일, 사용자 유형입니다.")
        void testSuccess() {
            User3 user = UserFactory.create(List.of(1, "user@email.com", UserType.CUSTOMER));

            assertEquals(new User3(1, "user@email.com", UserType.CUSTOMER), user);
        }

        @Test
        @DisplayName("리스트로 주어진 데이터의 수가 3보다 작으면 IllegalArgumentException을 throw 합니다.")
        void testThrowExceptionIfDataSizeUnder3() {
            assertThrows(IllegalArgumentException.class, () -> {
                UserFactory.create(List.of(1, "user@email.com"));
            });
        }
    }
}
