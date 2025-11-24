package com.jsantos.demo;

/**
 * @author javier santos
 * @author raul ripoll
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration(
exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class PoyakeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoyakeSpringApplication.class, args);
	}

}
