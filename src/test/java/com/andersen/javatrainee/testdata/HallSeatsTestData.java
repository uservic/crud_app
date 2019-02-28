package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.movietheatre.Hall;
import com.andersen.javatrainee.model.movietheatre.Seat;

import java.util.ArrayList;
import java.util.List;

public class HallSeatsTestData {

    public static final Hall TWO_ON_TWO_HALL =
            new Hall("Tiny Hall", 2,2);
    public static final Seat SEAT_ROWONE_NUMONE=
            new Seat(1,1,1, TWO_ON_TWO_HALL);

    public static List<Seat> makeSeats(Hall hall) {
        int rows = hall.getRowsQuantity();
        int seats = hall.getSeatsInRow();

        List<Seat> result = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats ; j++) {
                Seat seat = new Seat(i, j, hall);
                result.add(seat);
            }
        }
        return result;
    }

}
