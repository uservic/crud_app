package com.andersen.javatrainee.model.listeners;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.repository.dtype.DTypeRepository;
import com.andersen.javatrainee.service.BeanService;

import javax.persistence.PrePersist;

public class DictionaryListener {

    @PrePersist
    public void prePersist(Dictionary dictionary) {
        DTypeRepository dTypeRepository =
                BeanService.getBean(DTypeRepository.class);
        dictionary.setExt_id(dTypeRepository.
                incrementAndGetCount(dictionary.getClassSimpleName()));
    }

}