package com.andersen.javatrainee.util;

import com.andersen.javatrainee.util.exception.DuplicateFoundException;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static <T> T checkNotFoundWithLogin(T object, String login) {
        return checkNotFound(object, "login=" + login);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String arg) {
        if (found) {
            throw new DuplicateFoundException(arg);
        }
    }

}