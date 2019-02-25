package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Movie;
import com.andersen.javatrainee.repository.AbstractRepositoryTest;
import com.andersen.javatrainee.testdata.TestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.andersen.javatrainee.testdata.MovieTestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    MovieRepository repo;

    @Test
    void save() {
        Movie newMovie = new Movie(NEW_MOVIE);
        Movie savedMovie = repo.save(newMovie);
        assertEquals(3, repo.getAll().size());
        assertEquals(newMovie, savedMovie);
    }

    @Test
    void get() {
        Movie movie = repo.get(1);
        assertEquals(AMELIE_MOVIE, movie);
    }

    @Test
//    @Rollback(false)
    void update() {
        Movie updatedMovie = repo.save(UPDATED_MOVIE_AMELIE);
        assertEquals(UPDATED_MOVIE_AMELIE.getDescription(), updatedMovie.getDescription());
    }

    @Test
//    @Rollback(false)
    void delete() {
        repo.delete(2);
        assertEquals(AMELIE_MOVIE, repo.get(1));
        assertEquals(1, repo.getAll().size());
    }

    @Test
    void getAll() {
        List<Movie> movies = repo.getAll();
        TestHelper.assertMatch(movies, AMELIE_MOVIE, SPIDERMAN_2_MOVIE);
    }
}