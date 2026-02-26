package com.example.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OrderService.Domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
