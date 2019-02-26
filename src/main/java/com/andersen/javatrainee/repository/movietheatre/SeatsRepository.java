package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Seat;

import java.util.List;

public interface SeatsRepository {

    Seat add(Seat seat);

    void add(List<Seat> list);

    List<Seat>getAllByHallId(Integer hallId);

}
