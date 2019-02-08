package com.andersen.javatrainee.util;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.to.DictionaryTO;

import java.util.Arrays;
import java.util.List;

import static com.andersen.javatrainee.model.Dictionary.DICT_TYPES;

public class Util {

    public static List<String> makeDictTypesList() {
        return Arrays.asList(DICT_TYPES);
    }

    public static Dictionary createDictionaryFromTO(DictionaryTO dictTO) {
        String type = dictTO.getDictionaryType();
        Dictionary dictionary = null;
        switch (type.toLowerCase()) {
            case "role":
                dictionary = new Role();
                if (!dictTO.isNew()) {
                    dictionary.setId(dictTO.getId());
                }
                dictionary.setName(dictTO.getName());
                dictionary.setExt_id(dictTO.getExt_id());
                break;
            default:
                throw new IllegalArgumentException("No known DictionaryType found");
        }
        return dictionary;
    }

    public static DictionaryTO createDictionaryTO(Dictionary dict) {
        return new DictionaryTO(dict.getId(), dict.getClassSimpleName(),
                dict.getName(), dict.getExt_id());
    }

}