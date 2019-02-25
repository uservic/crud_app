package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private DataJpaMovieRepository dataJpaMovieRepository;

    @Autowired
    public MovieRepositoryImpl(DataJpaMovieRepository dataJpaMovieRepository) {
        this.dataJpaMovieRepository = dataJpaMovieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return dataJpaMovieRepository.save(movie);
    }

    @Override
    public Movie get(int id) {
        return dataJpaMovieRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        dataJpaMovieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getAll() {
        return dataJpaMovieRepository.findAll();
    }
}