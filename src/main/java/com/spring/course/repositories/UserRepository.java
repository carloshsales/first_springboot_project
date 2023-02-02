package com.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
		
}
