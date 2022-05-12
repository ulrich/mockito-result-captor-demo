package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    void updateUser(String id) {
        var user = userRepository.getUserById(id);

        if (user == null) {
            logger.warn("User {} not found", id);
        } else {
            logger.info("Found user: {}", user);
        }
    }
}
