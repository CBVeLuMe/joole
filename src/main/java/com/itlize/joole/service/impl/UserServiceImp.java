package com.itlize.joole.service.impl;

import com.itlize.joole.entity.User;
import com.itlize.joole.repository.UserRepository;
import com.itlize.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
