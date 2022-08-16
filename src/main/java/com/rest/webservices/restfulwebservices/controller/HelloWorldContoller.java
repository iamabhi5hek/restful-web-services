package com.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.services.HelloWorldBean;

@RestController
public class HelloWorldContoller {
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method=RequestMethod.GET, path = "/helloWorld")
	public String getHelloWorld() {
		return "Hello World using @RequestMapping";
	}
	
	@GetMapping(path = "/helloWorldUsingGet")
	public String getMessage() {
		return "Hello world using @GetMapping";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
	
	
	@GetMapping(path = "/hello-World-Internationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		//return "Hello world using @helloWorldInternationalized";
		
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@GetMapping(path = "/hello-world-internationalized2")
	public String helloWorldInternationalized2() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}
