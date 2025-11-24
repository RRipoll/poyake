package com.jsantos.rest.config;



import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

//http://localhost:8080/swagger-ui/#/

@Configuration
@ConditionalOnProperty(name="dev.mode.active", havingValue="true")

public class SwaggerConfig {
	public static final String SWAGGER_API_KEY = "e5215bafd61362e5416b8506689d4715";


	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Order Service API",
				"Order Service API Description",
				"1.0",
				"http://jsantos/terms",
				new Contact("jsantos", "https://jsantos.com", "apis@jsantos.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}	private ApiKey apiKey() {
		return new ApiKey(SWAGGER_API_KEY, "api_key", "header");
	}

	private SecurityContext securityContext() {
		// Selector for the paths this security context applies to
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				// Selector for the paths this security context applies to.
				.forPaths(PathSelectors.regex("/api/.*"))
				.build();	
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		// Here we same key defined in the security scheme mykey
		return Lists.newArrayList(new SecurityReference("mykey", authorizationScopes));
	}

	// Optional swagger-ui security configuration for oauth and apiKey settings
	@Bean
	public SecurityConfiguration security() {

	    return new SecurityConfiguration(
	        "test-app-client-id",
	        "test-app-client-secret",
	        "test-app-realm",
	        "test-app",
	        SWAGGER_API_KEY,
	        // How do you want to transport the api key via a HEADER (header) or QUERY_PARAM (query)?
	        ApiKeyVehicle.HEADER, 
	        // What header key needs to be used to send the api key. By default this value is set to api_key. Depending on how the security is setup the name of the header used may need to be different. 
	        // Overriding this value is a way to override the default behavior.	        
	        "api_key", 
	        "," /*scope separator*/);
	
	}
}