package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.Role;

public class DictionaryTestData {

    public static final Role ROLE_USER = new Role(1,"USER", 1);
    public static final Role ROLE_ADMIN = new Role(2,"ADMIN", 2);

    public static final Role NEW_ROLE = new Role("NEW_ROLE");
    public static final Role UPDATED_ROLE = new Role(1, "USER_UPDATED", 1);

}
