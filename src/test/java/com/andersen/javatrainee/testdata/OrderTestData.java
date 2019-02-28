package com.andersen.javatrainee.testdata;

import com.andersen.javatrainee.model.movietheatre.Order;

import static com.andersen.javatrainee.testdata.HallSeatsTestData.SEAT_ROWONE_NUMONE;
import static com.andersen.javatrainee.testdata.MovieSessionTestData.SESSION_ONE;
import static com.andersen.javatrainee.testdata.PriceCategoryTestData.MIDDAY_PCAT;
import static com.andersen.javatrainee.testdata.UserTestData.USER_JOE;

public class OrderTestData {

    public static final Order ORDER_ONE =
            new Order(1, MIDDAY_PCAT, USER_JOE, SESSION_ONE, SEAT_ROWONE_NUMONE);

}