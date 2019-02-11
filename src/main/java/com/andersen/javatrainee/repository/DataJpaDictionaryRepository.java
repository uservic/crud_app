package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataJpaDictionaryRepository extends JpaRepository<Dictionary, Integer> {

    @Query("select r from Role r where r.name=:name")
    Dictionary getRoleByName(@Param("name") String name);

    @Query("select d from Dictionary d where type(d) ='Role'")
    List<Role> getAllRoles();

}