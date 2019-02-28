package com.andersen.javatrainee.service.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Order;
import com.andersen.javatrainee.repository.movietheatre.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order get(int id) {
        return orderRepository.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        orderRepository.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

}