package com.ho.study.unit.testing.changeemail.example7_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    private final List<User2> saveData = new ArrayList<>();

    public List<Object> getUserById(Integer userId) {
        Optional<User2> findUserOptional = saveData.stream().filter(u -> u.getUserId().equals(userId)).findAny();

        if (findUserOptional.isPresent()) {
            User2 user = findUserOptional.get();
            return user.toList();
        } else {
            return new User2().toList();
        }
    }

    public List<Object> getCompany() {
        return List.of("company.com", 0);
    }

    public void saveCompany(Integer newNumber) {
    }

    public void saveUser(User2 user) {
        for (User2 u : saveData) {
            if (u.getUserId().equals(user.getUserId())) {
                saveData.remove(u);
                break;
            }
        }

        saveData.add(user);
    }

}
