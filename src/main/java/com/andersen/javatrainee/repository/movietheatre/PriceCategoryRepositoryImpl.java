package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.PriceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceCategoryRepositoryImpl implements PriceCategoryRepository {

    private DataJpaPriceCategoryRepository dataJpaPriceCategoryRepository;

    @Autowired
    public PriceCategoryRepositoryImpl(DataJpaPriceCategoryRepository dataJpaPriceCategoryRepository) {
        this.dataJpaPriceCategoryRepository = dataJpaPriceCategoryRepository;
    }

    @Override
    public PriceCategory save(PriceCategory category) {
        return dataJpaPriceCategoryRepository.save(category);
    }

    @Override
    public PriceCategory get(int id) {
        return dataJpaPriceCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        dataJpaPriceCategoryRepository.deleteById(id);
    }

    @Override
    public List<PriceCategory> getAll() {
        return dataJpaPriceCategoryRepository.findAll();
    }

}