package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Seat;
import com.andersen.javatrainee.repository.movietheatre.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService {

    private SeatsRepository seatsRepository;

    @Autowired
    public SeatsServiceImpl(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    @Override
    @Transactional
    public Seat add(Seat seat) throws Exception {
        return seatsRepository.add(seat);
    }

    @Override
    @Transactional
    public void add(List<Seat> list) {
        seatsRepository.add(list);
    }

    @Override
    public List<Seat> getAllByHallId(Integer hallId) {
        return seatsRepository.getAllByHallId(hallId);
    }

}
