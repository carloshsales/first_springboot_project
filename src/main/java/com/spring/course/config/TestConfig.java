package com.spring.course.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.course.entities.Order;
import com.spring.course.entities.User;
import com.spring.course.entities.enums.OrderStatus;
import com.spring.course.repositories.OrderRepository;
import com.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jupiter", "jupiter@teste.com", "74999999999", "juju");
		User u2 = new User(null, "Pandora", "pandora@teste.com", "74999999999", "dora");
		
		Order o1 = new Order(null, Instant.parse("2023-02-02T22:59:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-02-02T22:59:00Z"), OrderStatus.PAID, u2);
		
		List<User> listU = new ArrayList<>();
		listU.add(u1);
		listU.add(u2);

		userRepository.saveAll(listU);
		
		List<Order> listO = new ArrayList<>();
		listO.add(o1);
		listO.add(o2);

		orderRepository.saveAll(listO);
	}
	
	
}
