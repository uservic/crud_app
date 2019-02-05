package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;

import java.util.List;

public interface UserService {

    User save(User user) throws DuplicateFoundException;

    User get(int id);

    void delete(int id);

    List<User> getAll();

    User getByLogin(String login);

}