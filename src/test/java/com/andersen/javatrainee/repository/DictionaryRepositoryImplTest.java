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

@SpringJUnitConfig(locations = {"classpath:spring/db.xml", "classpath:spring/security.xml"})
@Transactional
class DictionaryRepositoryImplTest {

    @Autowired
    DictionaryRepositoryImpl repo;

    @Test
    void save() {
        Role new_role = NEW_ROLE;
        Role new_123 = new Role("role_123");
        Dictionary savedRole = repo.save(new_role);
        Dictionary savedRole123 = repo.save(new_123);
        List<Dictionary> allDictionaries = repo.getAll();
        assertEquals(4, allDictionaries.size());
        assertEquals(new_role, savedRole);
        assertEquals(3, savedRole.getExt_id().intValue());
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