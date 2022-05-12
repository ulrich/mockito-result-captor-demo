package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final Map<String, User> users = Map.of("1", new User("1", "Ulrich"));

    public User getUserById(String id) {
        if (!users.containsKey(id)) {
            return null;
        }
        return users.get(id);
    }
}
