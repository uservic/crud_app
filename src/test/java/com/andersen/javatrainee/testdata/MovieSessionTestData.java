package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.movietheatre.MovieSession;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.andersen.javatrainee.testdata.HallSeatsTestData.TWO_ON_TWO_HALL;
import static com.andersen.javatrainee.testdata.MovieTestData.AMELIE_MOVIE;

public class MovieSessionTestData {

    public static final MovieSession SESSION_ONE=
            new MovieSession(
                    1,
                    LocalDate.of(2019, 2, 1),
                    LocalTime.of(12,0),
                    AMELIE_MOVIE,
                    TWO_ON_TWO_HALL);

}