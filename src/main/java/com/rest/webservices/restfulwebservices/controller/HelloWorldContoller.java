package com.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContoller {

	@RequestMapping(method=RequestMethod.GET, path = "/helloWorld")
	public String getHelloWorld() {
		return "Hello World using @RequestMapping";
	}
	
	@GetMapping(path = "/helloWorldUsingGet")
	public String getMessage() {
		return "Hello world using @GetMapping";
	}
	
}
