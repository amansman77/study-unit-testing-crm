package com.ho.study.unit.testing.changeemail.example7_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    private static List<User> saveData = new ArrayList<>();

    public static List<Object> getUserById(Integer userId) {
        Optional<User> findUserOptional = saveData.stream().filter(u -> u.getUserId().equals(userId)).findAny();

        if (findUserOptional.isPresent()) {
            User user = findUserOptional.get();
            return user.toList();
        } else {
            return List.of();
        }
    }

    public static List<Object> getCompany() {
        return List.of("company.com", 0);
    }

    public static void saveCompany(Integer newNumber) {
    }

    public static void saveUser(User user) {
        for (User u : saveData) {
            if (u.getUserId().equals(user.getUserId())) {
                saveData.remove(u);
                break;
            }
        }

        saveData.add(user);
    }

}
