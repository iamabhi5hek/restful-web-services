package com.rest.webservices.restfulwebservices.factory;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserFactory {
	
	private Integer id;
	
	@Size(min = 2)
	private String name;
	
	@Past
	private Date birthDate;
	
	
	public UserFactory(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserFactory [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
