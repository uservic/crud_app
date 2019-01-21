package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User get(int id);

    void delete(int id);

    List<User> getAll();
    
}