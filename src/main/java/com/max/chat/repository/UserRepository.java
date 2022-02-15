package com.max.chat.repository;

import com.max.chat.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, User> map = new LinkedHashMap<>();

    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(map.values());
    }

    public Optional<User> getUserById(String userId) {
        return Optional.ofNullable(map.get(userId));
    }
}
