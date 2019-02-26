package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatsRepositoryImpl implements SeatsRepository{

    private DataJpaSeatsRepository dataJpaSeatsRepository;

    @Autowired
    public SeatsRepositoryImpl(DataJpaSeatsRepository dataJpaSeatsRepository) {
        this.dataJpaSeatsRepository = dataJpaSeatsRepository;
    }

    @Override
    public Seat add(Seat seat) {
        return dataJpaSeatsRepository.save(seat);
    }

    @Override
    public void add(List<Seat> list) {
        dataJpaSeatsRepository.saveAll(list);
    }

    @Override
    public List<Seat> getAllByHallId(Integer hallId) {
        return dataJpaSeatsRepository.findAllByHallId(hallId);
    }

}
