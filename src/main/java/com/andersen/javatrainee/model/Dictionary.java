package com.andersen.javatrainee.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.Hibernate;

import javax.persistence.*;

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
public abstract class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public Dictionary() {
    }

    public Dictionary(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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