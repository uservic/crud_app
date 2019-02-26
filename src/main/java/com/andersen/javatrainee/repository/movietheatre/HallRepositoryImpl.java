package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HallRepositoryImpl implements HallRepository {

    private DataJpaHallRepository dataJpaHallRepository;

    @Autowired
    public HallRepositoryImpl(DataJpaHallRepository dataJpaHallRepository) {
        this.dataJpaHallRepository = dataJpaHallRepository;
    }

    @Override
    public Hall add(Hall hall) {
        return dataJpaHallRepository.save(hall);
    }

}
