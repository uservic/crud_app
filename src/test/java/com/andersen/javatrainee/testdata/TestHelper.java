package com.andersen.javatrainee.testdata;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestHelper {

    public static <T> void assertMatch(Iterable<T> actual, T... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static <T> void assertMatch(Iterable<T> actual, Iterable<T> expected) {
        assertIterableEquals(actual, expected);
    }

}
