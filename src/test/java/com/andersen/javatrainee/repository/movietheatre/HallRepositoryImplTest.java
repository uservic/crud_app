package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Hall;
import com.andersen.javatrainee.model.movietheatre.Seat;
import com.andersen.javatrainee.repository.AbstractRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static com.andersen.javatrainee.testdata.HallSeatsTestData.TWO_ON_TWO_HALL;
import static com.andersen.javatrainee.testdata.HallSeatsTestData.makeSeats;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HallRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    private HallRepository hallRepo;

    @Autowired
    private SeatsRepository seatsRepo;

    @Test
    @Sql("classpath:db/test_dbscripts.sql")
    void add() {
        Hall savedHall = hallRepo.add(TWO_ON_TWO_HALL);
        List<Seat> seats = makeSeats(savedHall);
        seatsRepo.add(seats);

        List<Seat> seatList = seatsRepo.getAllByHallId(savedHall.getId());
        assertEquals(4, seatList.size());
    }

}