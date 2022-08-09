package com.rest.webservices.restfulwebservices.dao;

import java.util.List;

import com.rest.webservices.restfulwebservices.factory.UserFactory;

public interface UserServiceDAO {
	
	public List<UserFactory> findAll();
	
	public UserFactory save(UserFactory user);
	
	public UserFactory findOne(int userId);

}
