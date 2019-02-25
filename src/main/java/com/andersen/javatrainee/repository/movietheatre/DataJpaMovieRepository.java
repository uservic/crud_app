package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaMovieRepository extends JpaRepository<Movie, Integer> {

}