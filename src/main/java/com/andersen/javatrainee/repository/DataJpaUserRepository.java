package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaUserRepository extends JpaRepository<User, Integer> {

}