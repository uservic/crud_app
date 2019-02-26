package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataJpaSeatsRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findAllByHallId(Integer hallId);

}
