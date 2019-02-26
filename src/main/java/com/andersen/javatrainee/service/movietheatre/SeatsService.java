package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Seat;

import java.util.List;

public interface SeatsService {

    Seat add(Seat seat) throws Exception;

    void add(List<Seat> list);

    List<Seat>getAllByHallId(Integer hallId);

}
