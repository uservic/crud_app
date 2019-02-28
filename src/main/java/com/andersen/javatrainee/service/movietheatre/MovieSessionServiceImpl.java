package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.MovieSession;
import com.andersen.javatrainee.repository.movietheatre.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {

    private MovieSessionRepository movieSessionRepository;

    @Autowired
    public MovieSessionServiceImpl(MovieSessionRepository movieSessionRepository) {
        this.movieSessionRepository = movieSessionRepository;
    }

    @Override
    @Transactional
    public MovieSession save(MovieSession session) {
        return movieSessionRepository.save(session);
    }

    @Override
    public MovieSession get(int id) {
        return movieSessionRepository.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        movieSessionRepository.delete(id);
    }

    @Override
    public List<MovieSession> getAll() {
        return movieSessionRepository.getAll();
    }

}