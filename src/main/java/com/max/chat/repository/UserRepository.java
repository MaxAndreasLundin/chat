package com.max.chat.repository;

import com.github.javafaker.Faker;
import com.max.chat.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static final Faker faker = new Faker();
    private final Map<String, User> map = new LinkedHashMap<>();

    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(map.values());
    }

    public User getUserById(String userId) {
        return map.computeIfAbsent(userId, x -> {
            User user = new User();
            user.setId(x);
            user.setName(getRandomName());
            return user;
        });
    }

    private static String getRandomName() {
        return faker.name().fullName();
    }
}
