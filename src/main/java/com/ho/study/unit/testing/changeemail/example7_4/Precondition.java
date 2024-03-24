package com.ho.study.unit.testing.changeemail.example7_4;

public class Precondition {

    private Precondition() {}
    
    public static void requires(boolean requires) {
        if (!requires) {
            throw new IllegalArgumentException("필수 조건을 충족하지 못했습니다.");
        }
    }

}
