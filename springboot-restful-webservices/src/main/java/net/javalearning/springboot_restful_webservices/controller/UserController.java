package net.javalearning.springboot_restful_webservices.controller;

import lombok.AllArgsConstructor;
import net.javalearning.springboot_restful_webservices.entity.User;
import net.javalearning.springboot_restful_webservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    ///Build Create user rest API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Build get user by id rest api
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    //Build get all user by id rest api
    @GetMapping
    public ResponseEntity<List<User>> getUserById(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    /// Update User Data by user id
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") Long userId){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete User data by user id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
