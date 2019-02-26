package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaHallRepository extends JpaRepository<Hall, Integer> {

}
