package com.andersen.javatrainee.repository.movietheatre;

import com.andersen.javatrainee.model.movietheatre.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaOrderRepository
        extends JpaRepository<Order, Integer> {
}