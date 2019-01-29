package com.andersen.javatrainee.util;

import java.util.Arrays;
import java.util.List;

public class UserUtil {

    public static final String[] ROLES = {"USER", "ADMIN"};

    public static List<String> makeRolesList() {
        return Arrays.asList(ROLES);
    }

}