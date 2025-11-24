package com.etantolling.testrunner.testserver.rs.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.config.java.annotation.Import;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import(SwaggerConfig.class)
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("*** addResourceHandlers webjars");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
