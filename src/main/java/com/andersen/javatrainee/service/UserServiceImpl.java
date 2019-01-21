package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Repository<User> repository;

    @Autowired
    public UserServiceImpl(Repository<User> repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
