package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order get(int id);

    void delete(int id);

    List<Order> getAll();

}