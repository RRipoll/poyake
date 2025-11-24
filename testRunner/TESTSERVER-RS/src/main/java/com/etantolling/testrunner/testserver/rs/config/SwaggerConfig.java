package com.etantolling.testrunner.testserver.rs.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger is a specification and complete framework implementation for
 * describing, producing, consuming, and visualizing RESTful web services. The
 * goal of Swagger is to enable client and documentation systems to update at
 * the same pace as the server. The documentation of methods, parameters, and
 * models are tightly integrated into the server code, allowing APIs to always
 * stay in sync.
 * 
 * To access UI API: http://localhost:8080/NH-RS/swagger-ui.html#/
 * 
 * To access JSON API DOCs: http://localhost:8080/NH-RS/v2/api-docs An online
 * editor like Swagger Editor: http://editor.swagger.io/#/ can be used to see
 * json api-docs friendly.
 * 
 * http://springfox.github.io/springfox/docs/current/#getting-started
 * 
 * 
 * 
 * The security provisions in SpringFox at a high level, without getting into
 * the code, has different pieces that all work together in concert
 * 
 * The API itself needs to be protected. This is achieved by using, for
 * simplicity sake, spring security and may also use a combination of servlet
 * container and tomcat/jersey etc.
 * 
 * The security scheme which describes the techniques you’ve used to protect the
 * api. Spring fox supports whatever schemes swagger specification supports
 * (ApiKey, BasicAuth and OAuth2 (certain profiles))
 * 
 * Finally the security contexts which actually provides information on which
 * api’s are protected by which schemes. I think in your example, you’re missing
 * the last piece of the puzzle, the security context see 15.
 * 
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public final static String SWAGGER_API_KEY = "e5215bafd61362e5416b8506689d4715";

	private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

	@Bean
	public Docket api() {
		log.info("*** SwaggerConfig api");
		// By the moment, we only will show API for getting all account
		// information.
		// return new
		// Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/rest/.*")).build()
		// .apiInfo(apiInfo());
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/rest/.*"))
				.build()
				.apiInfo(apiInfo())
				// Sets up the security schemes used to protect the apis. Supported schemes are ApiKey, BasicAuth and OAuth
				// A declaration of the security schemes available to be used in the specification. This does NOT enforce the security schemes on the operations and only serves to provide the relevant 
				// details for each scheme.
				.securitySchemes(Lists.newArrayList(apiKey()));
				// Provides a way to globally set up security contexts for operation. The idea here is that we provide a way to select operations to be protected by one of the specified security schemes.				
//				.securityContexts(Lists.newArrayList(securityContext()));
		// @formatter:on		
	}

	private ApiInfo apiInfo() {
		String detailDescription = "The Account is a RESTful API that provides \n \n" + "Below is a list of available REST API calls for business account resources.";

		// @formatter:off
		return new ApiInfoBuilder()
				.title("Overview")
				.description(detailDescription)
				.termsOfServiceUrl("http://springfox.io")
				.contact("springfox")
				.license("IDC 0.1")
				.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
				.version("0.1")
				.build();
		// @formatter:on		
	}

	private ApiKey apiKey() {
		return new ApiKey("mykey", "api_key", "header");
	}

	private SecurityContext securityContext() {
		// Selector for the paths this security context applies to
		// @formatter:off
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				// Selector for the paths this security context applies to.
				.forPaths(PathSelectors.regex("/rest/.*"))
				.build();
		// @formatter:on		
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
		// http://localhost:8080/nh-rs/configuration/security
		// @formatter:off
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
		// @formatter:on		
	}
}