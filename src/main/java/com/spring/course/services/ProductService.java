package com.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course.entities.Product;
import com.spring.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return this.repository.findAll();
	}
	
	public Product FindById(Long id) {
		Optional<Product> product = this.repository.findById(id);
		return product.get();
	}
}
