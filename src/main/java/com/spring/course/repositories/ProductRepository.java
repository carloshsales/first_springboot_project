package com.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
