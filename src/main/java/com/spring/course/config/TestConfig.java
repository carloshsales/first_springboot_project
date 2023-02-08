package com.spring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.course.entities.Category;
import com.spring.course.entities.Order;
import com.spring.course.entities.OrderItem;
import com.spring.course.entities.Payment;
import com.spring.course.entities.Product;
import com.spring.course.entities.User;
import com.spring.course.entities.enums.OrderStatus;
import com.spring.course.repositories.CategoryRepository;
import com.spring.course.repositories.OrderItemRepository;
import com.spring.course.repositories.OrderRepository;
import com.spring.course.repositories.ProductRepository;
import com.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jupiter", "jupiter@teste.com", "74999999999", "juju");
		User u2 = new User(null, "Pandora", "pandora@teste.com", "74999999999", "dora");
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2023-02-02T20:59:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-02-02T22:59:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Product p1 = new Product(null, "Notebook", "Portable computer", 3000.00, "notebookimage.com");
		Product p2 = new Product(null, "Dracula", "Portable computer", 47.00, "draculabookimage.com");
		Product p3 = new Product(null, "Smartphone", "Portable computer", 1235.00, "smartphoneimage.com");
		Product p4 = new Product(null, "SmartTV", "Smart TV", 1235.00, "smartphoneimage.com");
		Product p5 = new Product(null, "Kindle", "eletronic books", 1235.00, "smartphoneimage.com");
		
		p1.getCategories().add(c3);
		p2.getCategories().add(c2);
		p3.getCategories().add(c3);
		p3.getCategories().add(c1);
		p4.getCategories().add(c3);
		p4.getCategories().add(c1);
		p5.getCategories().add(c1);
		p5.getCategories().add(c2);
		p5.getCategories().add(c3);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 3, p1.getPrice());
		OrderItem oi2 = new OrderItem(o2, p2, 1, p2.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o1, p4, 3, p4.getPrice());
		OrderItem oi5 = new OrderItem(o1, p5, 5, p5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));

		
		Payment pay1 = new Payment(null, Instant.parse("2023-02-02T22:59:00Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}
	
	
}
