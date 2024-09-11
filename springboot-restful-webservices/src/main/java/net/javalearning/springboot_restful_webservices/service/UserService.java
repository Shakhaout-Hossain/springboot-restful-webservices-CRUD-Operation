package net.javalearning.springboot_restful_webservices.service;

import net.javalearning.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUserById(Long userId);
}
