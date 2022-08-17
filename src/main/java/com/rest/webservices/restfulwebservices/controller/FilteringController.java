package com.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.factory.FilterBeanFactory;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public FilterBeanFactory retrieveBean() {
		return new FilterBeanFactory("value1", "value2", "value3", "value4");
	}

	
	@GetMapping("/filtering-list")
	public List<FilterBeanFactory> retrieveBeanAsList() {
		return Arrays.asList(new FilterBeanFactory("value1", "value2", "value3", "value4"),
				new FilterBeanFactory("value1.1", "value2.1", "value3.1", "value4.1"));
	}
}
