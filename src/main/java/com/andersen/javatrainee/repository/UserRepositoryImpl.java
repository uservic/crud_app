package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository

public class UserRepositoryImpl implements UserRepository {

    private DataJpaUserRepository dataJpaUserRepository;

    @Autowired
    public UserRepositoryImpl(DataJpaUserRepository dataJpaUserRepository) {
        this.dataJpaUserRepository = dataJpaUserRepository;
    }

    @Override
    public User save(User user) {
        return dataJpaUserRepository.save(user);
    }

    @Override
    public User get(int id) {
        return dataJpaUserRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
    dataJpaUserRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return dataJpaUserRepository.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return dataJpaUserRepository.getByLogin(login);
    }
}