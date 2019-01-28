package com.andersen.javatrainee.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Role")
public class Role extends Dictionary implements GrantedAuthority {

    @Column(name = "name")
    private String name;

    @Column(name = "ext_id")
    private Integer ext_id;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    public Role() {

    }

    public Role(String name, Integer ext_id) {
        this(null, name, ext_id);
    }

    public Role(Integer id, String name, Integer ext_id) {
        super(id);
        this.name = name;
        this.ext_id = ext_id;
    }

    public Role(Role role) {
        this(role.getId(), role.getName(), role.getExt_id());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExt_id() {
        return ext_id;
    }

    public void setExt_id(Integer ext_id) {
        this.ext_id = ext_id;
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
        return "ROLE_" + getName();
    }
}