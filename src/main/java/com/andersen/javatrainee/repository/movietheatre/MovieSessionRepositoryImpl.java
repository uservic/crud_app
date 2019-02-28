package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieSessionRepositoryImpl implements MovieSessionRepository {

    private DataJpaMovieSessionRepository movieSessionRepository;

    @Autowired
    public MovieSessionRepositoryImpl(DataJpaMovieSessionRepository movieSessionRepository) {
        this.movieSessionRepository = movieSessionRepository;
    }

    @Override
    public MovieSession save(MovieSession session) {
        return movieSessionRepository.save(session);
    }

    @Override
    public MovieSession get(int id) {
        return movieSessionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        movieSessionRepository.deleteById(id);
    }

    @Override
    public List<MovieSession> getAll() {
        return movieSessionRepository.findAll();
    }

}