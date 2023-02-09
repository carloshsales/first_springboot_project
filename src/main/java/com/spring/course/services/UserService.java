package com.spring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.course.entities.User;
import com.spring.course.repositories.UserRepository;
import com.spring.course.services.exceptions.DatabaseException;
import com.spring.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User userUpdated) {
		try {
			User userToUpdate = repository.getReferenceById(id);
			updateData(userToUpdate, userUpdated);
			return repository.save(userToUpdate);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User userToUpdate, User userUpdated) {
		userToUpdate.setName(userUpdated.getName());
		userToUpdate.setEmail(userUpdated.getEmail());
		userToUpdate.setPhone(userUpdated.getPhone());
	}
}
