package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaMovieSessionRepository
        extends JpaRepository<MovieSession, Integer> {
}
