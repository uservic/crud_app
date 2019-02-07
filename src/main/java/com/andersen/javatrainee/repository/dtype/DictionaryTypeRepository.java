package com.andersen.javatrainee.repository.dtype;

import com.andersen.javatrainee.model.DictionaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DictionaryTypeRepository
        extends JpaRepository<DictionaryType, String> {

    @Query("select dt from DictionaryType dt where  dt.name=:name")
    DictionaryType findByName(@Param("name") String name);

}
