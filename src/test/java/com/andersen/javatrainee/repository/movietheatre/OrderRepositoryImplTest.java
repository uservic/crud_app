package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Order;
import com.andersen.javatrainee.repository.AbstractRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.andersen.javatrainee.testdata.OrderTestData.ORDER_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    private OrderRepository repo;

    @Test
    void save() {
    }

    @Test
    void get() {
        Order order = repo.get(1);
        assertEquals(ORDER_ONE, order);
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

}