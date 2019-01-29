package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.andersen.javatrainee.UserTestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(locations = {"classpath:spring/db.xml", "classpath:spring/security.xml"})
@Transactional
class UserRepositoryImplTest {

    @Autowired
    UserRepositoryImpl repo;

    @Test
    void save() {
        User newUser = new User(new User(NEW_USER));
        User created = repo.save(newUser);
        assertEquals(5, repo.getAll().size());
        assertEquals(newUser, created);
    }

    @Test
    void get() {
        User user = repo.get(1);
        assertEquals(USER_JOE, user);
    }

    @Test
    void delete() {
        repo.delete(3);
        List<User> allUsers = repo.getAll();
        assertEquals(3, allUsers.size());
        assertMatch(allUsers, USER_JOE, USER_BOB, USER_ZOE);
    }

    @Test
    @Rollback(false)
    void update() {
        User updatedUser = repo.save(UPDATED_USER_JOE);
        assertEquals(UPDATED_USER_JOE.getLogin(), updatedUser.getLogin());
        assertEquals(UPDATED_USER_JOE.getPassword(), updatedUser.getPassword());
        assertEquals(UPDATED_USER_JOE.getRole().getName(),
                updatedUser.getRole().getName());
    }

    @Test
    void getAll() {
        List<User> allUsers = repo.getAll();
        assertMatch(allUsers, USER_JOE, USER_BOB, USER_ANN, USER_ZOE);
    }
}