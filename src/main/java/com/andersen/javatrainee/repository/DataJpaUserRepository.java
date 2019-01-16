package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DataJpaUserRepository extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);

    @Override
    Optional<User> findById(Integer id);

//    @Transactional
//    @Modifying
//    @Query("delete from user u where u.id=:id")
//    int delete(@Param("id") int id);

    @Override
    List<User> findAll();

}