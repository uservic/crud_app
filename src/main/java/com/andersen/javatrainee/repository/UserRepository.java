package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Repository

public class UserRepository extends AbstractRepository<User> {

    @Autowired
    public UserRepository(DataJpaUserRepository dataJpaUserRepository) {
        this.jpaRepository = dataJpaUserRepository;
    }
}