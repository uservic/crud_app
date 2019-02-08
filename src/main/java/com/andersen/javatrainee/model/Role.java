package com.andersen.javatrainee.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Role")
public class Role extends Dictionary implements GrantedAuthority {

    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";

//    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//    private Set<User> users;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Integer ext_id) {
        this(null, name, ext_id);
    }

    public Role(Integer id, String name, Integer ext_id) {
        super(id, name, ext_id);
    }

    public Role(Role role) {
        this(role.getId(), role.getName(), role.getExt_id());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ext_id=" + ext_id +
                '}';
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }

}