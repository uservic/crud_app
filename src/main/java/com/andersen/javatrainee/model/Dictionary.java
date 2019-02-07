package com.andersen.javatrainee.model;

import com.andersen.javatrainee.model.listeners.DictionaryListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "dictionary")
@DiscriminatorColumn(name = "discriminator")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "dictType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Role.class, name = "Role")
})
@EntityListeners(DictionaryListener.class)
public abstract class Dictionary {

    public static final String[] DICT_TYPES = {"ROLE"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 15, message = "Name must be from 3 to 15 characters")
    protected String name;

    @Column(name = "ext_id")
    protected Integer ext_id;

    public Dictionary() {
    }

    public Dictionary(String name, Integer ext_id) {
        this(null, name, ext_id);
    }

    public Dictionary(Integer id, String name, Integer ext_id) {
        this.id = id;
        this.name = name;
        this.ext_id = ext_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @JsonIgnore
    public String getClassSimpleName() {
        return getClass().getSimpleName();
    }

    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(Hibernate.getClass(o))) return false;
        Dictionary dictionary = (Dictionary) o;
        return id != null && id.equals(dictionary.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }

}