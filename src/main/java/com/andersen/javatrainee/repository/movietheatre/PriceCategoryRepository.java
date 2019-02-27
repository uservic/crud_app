package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.PriceCategory;

import java.util.List;

public interface PriceCategoryRepository {

    PriceCategory save(PriceCategory category);

    PriceCategory get(int id);

    void delete(int id);

    List<PriceCategory> getAll();

}