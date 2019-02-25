package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;

import java.util.List;

public interface MovieService {

    Movie save(Movie movie) throws Exception;

    Movie get(int id);

    void delete(int id);

    List<Movie> getAll();
}
