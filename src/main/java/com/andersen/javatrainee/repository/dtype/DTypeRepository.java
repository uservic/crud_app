package com.andersen.javatrainee.repository.dtype;

import org.springframework.transaction.annotation.Transactional;

public interface DTypeRepository {

    @Transactional
    Integer incrementAndGetCount(String name);

}