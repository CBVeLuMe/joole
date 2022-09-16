package com.itlize.joole.controller;

import com.itlize.joole.entity.User;
import com.itlize.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/get-users")
    public List<User> readUsers() {
        return service.findAll();
    }

    @GetMapping("/get-user")
    public User readUserById(@RequestParam("user-id") Integer userId) {
        return service.findById(userId);
    }

    @PostMapping("/post-user")
    public User createUser(@RequestParam("name") String userName, @RequestParam("password") String password, @RequestParam("first-name") String firstName, @RequestParam("last-name") String lastName, @RequestParam("email-address") String emailAddress, @RequestParam("phone-number") String phoneNumber) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        user.setPhoneNumber(phoneNumber);
        return service.save(user);
    }

    @PutMapping("/put-user-name")
    public User updateUser(@RequestParam("id") Integer id,
                           @RequestParam("first-name") String firstName,
                           @RequestParam("last-name") String lastName) {
        User user = service.findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        String name = firstName + " " + lastName;
        user.setName(name);
        return service.save(user);
    }

    @DeleteMapping("/delete-user")
    public void deleteUserById(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }
}
