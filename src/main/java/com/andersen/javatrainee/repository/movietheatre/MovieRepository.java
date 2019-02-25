package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;

import java.util.List;

public interface MovieRepository {

    Movie save(Movie movie);

    Movie get(int id);

    void delete(int id);

    List<Movie> getAll();

}
