package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.andersen.javatrainee.DictionaryTestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(locations = "classpath:spring/db.xml")
@Transactional
class DictionaryRepositoryTest {

    @Autowired
    DictionaryRepository repo;

    @Test
    void save() {
        Role new_role = new Role(NEW_ROLE);
        Dictionary savedRole = repo.save(new_role);
        List<Dictionary> allDictionaries = repo.getAll();
        assertEquals(3, allDictionaries.size());
        assertEquals(new_role, savedRole);
    }

    @Test
    void get() {
        Dictionary dictionaryRole = repo.get(1);
        assertTrue(dictionaryRole instanceof Role);
        assertEquals(ROLE_USER, dictionaryRole);
    }

    @Test
    void update() {
        Dictionary updatedRole = repo.save(UPDATED_ROLE);
        assertEquals(UPDATED_ROLE.getName(), ((Role) updatedRole).getName());
    }

    @Test
    void delete() {
        repo.delete(1);
        List<Dictionary> allDictionaries = repo.getAll();
        assertEquals(1, allDictionaries.size());
        assertMatch(allDictionaries, ROLE_ADMIN);
    }

    @Test
    void getAll() {
        List<Dictionary> allDictionaries = repo.getAll();
        assertMatch(allDictionaries, ROLE_USER, ROLE_ADMIN);
    }
}