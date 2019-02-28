package com.andersen.javatrainee.model.movietheatre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_sessions")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieSession extends AbstractEntity {

    @Column(name = "date")
    @FutureOrPresent
    @NotNull(message = "Date must not be null")
    private LocalDate date;

    @Column(name = "time")
    @NotNull(message = "Time must not be null")
    private LocalTime time;

    @JoinColumn(name = "movie_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Movie movie;

    @JoinColumn(name = "hall_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Hall hall;

    public MovieSession(LocalDate date, LocalTime time, Movie movie, Hall hall) {
        this(null, date, time, movie, hall);
    }

    public MovieSession(Integer id, LocalDate date, LocalTime time, Movie movie, Hall hall) {
        super(id);
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.hall = hall;
    }

}