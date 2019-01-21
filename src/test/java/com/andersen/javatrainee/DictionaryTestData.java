package com.andersen.javatrainee;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DictionaryTestData {

    public static final Role ROLE_USER = new Role(1,"USER", 1);
    public static final Role ROLE_ADMIN = new Role(2,"ADMIN", 2);

    public static final Role NEW_ROLE = new Role("NEW_ROLE", 3);
    public static final Role UPDATED_ROLE = new Role(1, "USER_UPDATED", 1);

    public static void assertMatch(Iterable<Dictionary> actual, Dictionary... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dictionary> actual, Iterable<Dictionary> expected) {
        assertIterableEquals(actual, expected);
    }
}
