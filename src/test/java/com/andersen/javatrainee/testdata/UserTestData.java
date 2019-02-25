package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;

public class UserTestData {

    public static final User USER_JOE =
            new User(1,"Joe", "11111",
                    new Role(2,"ADMIN", 2));
    public static final User USER_BOB =
            new User(2,"Bob", "22222",
                    new Role(1,"USER", 1));
    public static final User USER_ANN =
            new User(3,"Ann", "33333",
                    new Role(1,"USER", 1));
    public static final User USER_ZOE =
            new User(4,"Zoe", "44444",
                    new Role(1,"USER", 1));

    public static final User NEW_USER =
            new User("Peter", "55555",
                    new Role(2,"ADMIN", 2));

    public static final User UPDATED_USER_JOE =
            new User(1,"Joe_Updated", "00000",
                    new Role(1,"USER", 1));

}
