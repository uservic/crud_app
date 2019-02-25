package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;
import com.andersen.javatrainee.repository.movietheatre.MovieRepository;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Movie save(Movie movie) throws DuplicateFoundException {
//        ValidationUtil
        return repository.save(movie);
    }

    @Override
    public Movie get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Movie> getAll() {
        return repository.getAll();
    }

}