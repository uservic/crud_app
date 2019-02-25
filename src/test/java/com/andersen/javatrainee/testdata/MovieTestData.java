package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.movietheatre.Movie;

public class MovieTestData {

    public static final Movie NEW_MOVIE =
            new Movie("Deep space", "Deep space description");
    public static final Movie AMELIE_MOVIE =
            new Movie(1, "Amelie", "Amelie description");
    public static final Movie SPIDERMAN_2_MOVIE =
            new Movie(2, "Spiderman 2", "Spiderman 2 description");
    public static final Movie UPDATED_MOVIE_AMELIE =
            new Movie(1, "Amelie", "Amelie Updated description");

}
