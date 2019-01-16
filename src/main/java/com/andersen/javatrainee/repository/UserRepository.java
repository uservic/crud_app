package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User get(int id);

    void delete(int id);

    List<User> getAll();

}