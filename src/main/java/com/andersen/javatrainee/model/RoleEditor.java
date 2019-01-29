package com.andersen.javatrainee.model;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class RoleEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Role role = (Role) getValue();
        return role == null ? "" : role.getName();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            Role role = new Role();
            switch (text.toLowerCase()) {
                case "user":
                    role.setId(1);
                    role.setExt_id(1);
                    break;
                case "admin":
                    role.setId(2);
                    role.setExt_id(2);
                    break;
            }
            role.setName(text);
            setValue(role);
        }
    }

}