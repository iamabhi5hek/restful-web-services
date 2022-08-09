package com.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.factory.UserFactory;

@Component
public class UserServiceDAOImpl implements UserServiceDAO{
	
	private static List<UserFactory> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new UserFactory(1, "Adam", new Date()));
		users.add(new UserFactory(2, "Eve", new Date()));
		users.add(new UserFactory(3, "John", new Date()));
	}

	@Override
	public List<UserFactory> findAll() {
		return users;
	}

	@Override
	public UserFactory save(UserFactory user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	@Override
	public UserFactory findOne(int userId) {
		for(UserFactory user : users) {
			if(user.getId() == userId)
				return user;
		}
		return null;
	}
	
}
