package com.ho.study.unit.testing.changeemail.example7_3;

public class Precondition {

    public static void requires(Boolean requires) {
        if (!requires) {
            throw new IllegalArgumentException("필수 조건을 충족하지 못했습니다.");
        }
    }

}
