package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.MovieSession;

import java.util.List;

public interface MovieSessionRepository {

    MovieSession save(MovieSession session);

    MovieSession get(int id);

    void delete(int id);

    List<MovieSession> getAll();

}
