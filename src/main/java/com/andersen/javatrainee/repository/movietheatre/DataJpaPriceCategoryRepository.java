package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.PriceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaPriceCategoryRepository
        extends JpaRepository<PriceCategory, Integer> {
}