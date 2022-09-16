package com.itlize.joole.service;

import com.itlize.joole.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void findAll() {
        Assertions.assertNotNull(service.findAll());
    }

    @Test
    void findById() {
        User user = new User();
        user.setName("user_junit");
        user.setPassword("pw");
        user.setFirstName("fn");
        user.setLastName("ln");
        user.setEmailAddress("uj@itlize.com");
        user.setPhoneNumber("123 456 789");
        service.save(user);
        Assertions.assertNotNull(service.findById(user.getId()));
    }


    @Test
    void save() {
        User user = new User();
        user.setName("user_junit");
        user.setPassword("pw");
        user.setFirstName("fn");
        user.setLastName("ln");
        user.setEmailAddress("a@b.com");
        user.setPhoneNumber("123 456 759");
        service.save(user);
        Assertions.assertNotNull(service.findById(user.getId()));
    }

    @Test
    void deleteById() {
        User user = new User();
        user.setName("user_junit");
        user.setPassword("pw");
        user.setFirstName("fn");
        user.setLastName("ln");
        user.setEmailAddress("a@b.com");
        user.setPhoneNumber("123 456 759");
        service.save(user);
        Assertions.assertNotNull(service.findById(user.getId()));
        service.deleteById(user.getId());
        Assertions.assertNull(service.findById(user.getId()));
    }
}