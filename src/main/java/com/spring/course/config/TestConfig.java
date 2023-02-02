package com.spring.course.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.course.entities.User;
import com.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jupiter", "jupiter@teste.com", "74999999999", "juju");
		User u2 = new User(null, "Pandora", "pandora@teste.com", "74999999999", "dora");
		
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
	
		userRepository.saveAll(list);
	}
	
	
}
