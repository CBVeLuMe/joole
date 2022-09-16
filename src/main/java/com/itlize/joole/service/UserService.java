package com.itlize.joole.service;

import com.itlize.joole.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer Id);

    User save(User user);

    void deleteById(Integer id);
}
