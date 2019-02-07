package com.andersen.javatrainee.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DictionaryTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;

    private String dictionaryType;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 15, message = "Name must be from 3 to 15 characters")
    protected String name;

    protected Integer ext_id;

    public DictionaryTO() {

    }

    public DictionaryTO(Integer id, String dictionaryType, String name, Integer ext_id) {
        this.id = id;
        this.dictionaryType = dictionaryType;
        this.name = name;
        this.ext_id = ext_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
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

    public boolean isNew() {
        return this.id == null;
    }

    public String getClassSimpleName() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "DictionaryTO{" +
                "id=" + id +
                ", dictionaryType='" + dictionaryType + '\'' +
                ", name='" + name + '\'' +
                ", ext_id=" + ext_id +
                '}';
    }

}
