package com.ho.study.unit.testing.changeemail.example7_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("회사를 테스트하는 클래스입니다.")
class CompanyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("입력된 직원의 수만금 직원 수를 증감합니다.")
    void testChangeNumberOfEMployees(Integer delta) {
        Company company = new Company("admin@company.com", 0);

        company.changeNumberOfEMployees(delta);

        assertEquals(
            new Company("admin@company.com", delta), 
            company,
            "delta 에 따라 직원수가 증감해야 합니다."
        );
    }

    @Nested
    @DisplayName("사용자 이메일이 기업의 도메인과 같은지 확인합니다.")
    class testIsEmailCorporate {

        @ParameterizedTest
        @ValueSource(strings = {"user@company.com", "user@company.com@company.com"})
        @DisplayName("기업의 도메인과 같습니다.")
        void testTrue() {
            Company company = new Company("company.com", 0);
            
            Boolean isEmailCorporate = company.isEmailCorporate("user@company.com");

            assertTrue(isEmailCorporate, "기업의 도메인과 같습니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"user@company,com", "user@@company,com", "user@company.comcom"})
        @DisplayName("기업의 도메인과 다릅니다.")
        void testFalse(String userDomain) {
            Company company = new Company("company.com", 0);
            
            Boolean isEmailCorporate = company.isEmailCorporate(userDomain);

            assertFalse(isEmailCorporate, "기업의 도메인과 다릅니다.");
        }
    }
}
