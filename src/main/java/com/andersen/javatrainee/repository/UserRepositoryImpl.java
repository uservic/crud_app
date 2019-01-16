package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataJpaUserRepository dataJpaUserRepository;

    @Autowired
    public UserRepositoryImpl(DataJpaUserRepository dataJpaUserRepository) {
        this.dataJpaUserRepository = dataJpaUserRepository;
    }

    public User save(User user) {
        return dataJpaUserRepository.save(user);
    }

    public User get(int id) {
        return dataJpaUserRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        dataJpaUserRepository.deleteById(id);
    }

    public List<User> getAll() {
        return dataJpaUserRepository.findAll();
    }
}