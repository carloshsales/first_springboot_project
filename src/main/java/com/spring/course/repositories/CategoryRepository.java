package com.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
