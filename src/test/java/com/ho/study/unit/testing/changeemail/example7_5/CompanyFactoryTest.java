package com.ho.study.unit.testing.changeemail.example7_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("회사 팩토리 클래스를 테스트합니다.")
public class CompanyFactoryTest {

    @Nested
    @DisplayName("회사를 생성합니다.")
    class testCreate {

        @Test
        @DisplayName("성공적으로 생성합니다.")
        void testSuccess() {
            Company company = CompanyFactory.create(List.of("company.com", 0));

            assertEquals(
                new Company("company.com", 0), 
                company,
                "company.com 의 도메인과 직원수가 0인 회사를 생성합니다."
            );
        }

        @Test
        @DisplayName("회사를 생성하는 데이터가 2개보다 작으면 IllegalArgumentException 을 발생합니다.")
        void testThrowIllegalArgumentExceptionIfDataSizeLessTwo() {
            
            assertThrows(IllegalArgumentException.class, () -> {
                CompanyFactory.create(List.of("company.com"));
            });
        }
    }
}
