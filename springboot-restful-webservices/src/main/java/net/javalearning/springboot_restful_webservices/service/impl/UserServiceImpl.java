package net.javalearning.springboot_restful_webservices.service.impl;

import lombok.AllArgsConstructor;
import net.javalearning.springboot_restful_webservices.entity.User;
import net.javalearning.springboot_restful_webservices.repository.UserRepository;
import net.javalearning.springboot_restful_webservices.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exisUser = userRepository.findById(user.getId()).get();
        exisUser.setFirstName(user.getFirstName());
        exisUser.setLastName(user.getLastName());
        exisUser.setEmail(user.getEmail());
        return userRepository.save(exisUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
