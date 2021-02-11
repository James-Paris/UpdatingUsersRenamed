package com.hcl.updateuser.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.updateuser.entity.User;
import com.hcl.updateuser.repository.UserRepository;

@Service
public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repo;
	
	public void updateUser(User user) {
		User currentData = repo.findById(user.getId()).get();
		currentData.setUsername(user.getUsername());
		currentData.setPassword(user.getPassword());
		repo.save(currentData);
	}
	
	public Optional<User> searchUser(Long id) {
		log.info("UserId: " + id);
		Optional<User> user = repo.findById(id);
		log.info("Retrieved user: " + user);
		return user;
	}
	
	
} 
