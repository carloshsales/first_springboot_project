package com.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
