package com.ho.study.unit.testing.changeemail.example7_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    private final List<User5> saveData = new ArrayList<>();

    public List<Object> getUserById(Integer userId) {
        Optional<User5> findUserOptional = saveData.stream().filter(u -> u.getUserId().equals(userId)).findAny();

        if (findUserOptional.isPresent()) {
            User5 user = findUserOptional.get();
            return user.toList();
        } else {
            return new User5().toList();
        }
    }

    public List<Object> getCompany() {
        return List.of("company.com", 0);
    }

    public void saveCompany(Integer newNumber) {
        // 회사를 저장하는 구현은 생략한다.
    }

    public void saveCompany(Company afterCompany) {
        // 회사를 저장하는 구현은 생략한다.
    }

    public void saveUser(User5 user) {
        for (User5 u : saveData) {
            if (u.getUserId().equals(user.getUserId())) {
                saveData.remove(u);
                break;
            }
        }

        saveData.add(user);
    }
}
