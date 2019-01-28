package com.andersen.javatrainee.web;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;

import java.util.Collections;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public AuthorizedUser(User user) {
        super(user.getLogin(), user.getPassword(), Collections.singletonList(user.getRole()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}