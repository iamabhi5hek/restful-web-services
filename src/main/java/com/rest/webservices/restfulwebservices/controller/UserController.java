package com.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.dao.UserServiceDAOImpl;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.rest.webservices.restfulwebservices.factory.UserFactory;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceDAOImpl userServiceDAOImpl;

	//retrieve all users
	@GetMapping("/users")
	public List<UserFactory> retrieveAllUsers(){
		return userServiceDAOImpl.findAll();
	}
	
	//retrieve user(by id)
	@GetMapping("/users/{id}")
	public UserFactory retrieveById(@PathVariable int id) {
		
		UserFactory user = userServiceDAOImpl.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UserFactory user) {
		UserFactory savedUser = userServiceDAOImpl.save(user);
		
		//now we need to pass the status of request
		//we use ResponseEntity
		 
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
	}

	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		
		UserFactory user = userServiceDAOImpl.deleteById(id);
		
		if(user == null)
			throw new UserNotFoundException("id-" + id);
	}
	
}
