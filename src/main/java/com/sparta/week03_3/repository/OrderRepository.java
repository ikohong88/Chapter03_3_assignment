package com.sparta.week03_3.repository;

import com.sparta.week03_3.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
