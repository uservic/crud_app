package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.PriceCategory;
import com.andersen.javatrainee.repository.movietheatre.PriceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PriceCategoryServiceImpl implements PriceCategoryService {

    private PriceCategoryRepository priceCategoryRepository;

    @Autowired
    public PriceCategoryServiceImpl(PriceCategoryRepository priceCategoryRepository) {
        this.priceCategoryRepository = priceCategoryRepository;
    }

    @Override
    @Transactional
    public PriceCategory save(PriceCategory category) {
        return priceCategoryRepository.save(category);
    }

    @Override
    public PriceCategory get(int id) {
        return priceCategoryRepository.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        priceCategoryRepository.delete(id);
    }

    @Override
    public List<PriceCategory> getAll() {
        return priceCategoryRepository.getAll();
    }

}