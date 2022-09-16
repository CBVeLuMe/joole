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

    public List<User> readUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User readUserById(@PathVariable("id") Integer userId) {
        return service.findById(userId);
    }

    @PostMapping("/users")
    public User createUser(@RequestParam("name") String userName,
                           @RequestParam("password") String password,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("emailAddress") String emailAddress,
                           @RequestParam("phoneNumber") String phoneNumber) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        user.setPhoneNumber(phoneNumber);
        return service.save(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestParam("id") Integer id,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        User user = service.findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        String name = firstName + " " + lastName;
        user.setName(name);
        return service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
