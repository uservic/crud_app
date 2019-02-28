package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private DataJpaOrderRepository dataJpaOrderRepository;

    @Autowired
    public OrderRepositoryImpl(DataJpaOrderRepository dataJpaOrderRepository) {
        this.dataJpaOrderRepository = dataJpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        return dataJpaOrderRepository.save(order);
    }

    @Override
    public Order get(int id) {
        return dataJpaOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        dataJpaOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return dataJpaOrderRepository.findAll();
    }

}