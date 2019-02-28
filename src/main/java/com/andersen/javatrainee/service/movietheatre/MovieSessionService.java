package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.MovieSession;

import java.util.List;

public interface MovieSessionService {

    MovieSession save(MovieSession session);

    MovieSession get(int id);

    void delete(int id);

    List<MovieSession> getAll();

}