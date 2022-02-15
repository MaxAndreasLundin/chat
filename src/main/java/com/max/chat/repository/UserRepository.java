package com.max.chat.repository;

import com.max.chat.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, User> map = new LinkedHashMap<>();

    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(map.values());
    }
}
