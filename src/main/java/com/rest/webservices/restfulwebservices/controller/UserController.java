package com.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.dao.UserServiceDAOImpl;
import com.rest.webservices.restfulwebservices.factory.UserFactory;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceDAOImpl userServiceDAOImpl;

	//retrieve all users
	@GetMapping(path = "/users")
	public List<UserFactory> retrieveAllUsers(){
		return userServiceDAOImpl.findAll();
	}
	
	//retrieve user(by id)
	@GetMapping(path = "/users/{id}")
	public UserFactory retrieveById(@PathVariable int id) {
		return userServiceDAOImpl.findOne(id);
	}
}
