package com.jsantos.rest;

import javax.annotation.ManagedBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@ManagedBean
@SpringBootApplication
public class RestspringApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(RestspringApplication.class, args);
	}

	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestspringApplication.class);
	}
	
	
}
