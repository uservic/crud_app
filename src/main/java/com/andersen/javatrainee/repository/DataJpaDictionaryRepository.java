package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaDictionaryRepository extends JpaRepository<Dictionary, Integer> {

}