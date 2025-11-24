package com.jsantos.rest.config.swagger;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.service.Parameter;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class AuthorizationTokenHeaderBuilder implements OperationBuilderPlugin {
  // it is not used, only as example.
	public static final String API_AUTH_ENDPOINT = "/api/auth";
	public static final String HEADER_PARAMETER_TYPE = "header";
	public static final String HEADER_DESCRIPTION = "Header to carry Bearer Token";
	public static final String TOKEN_HEADER_NAME = "AUTHORIZATION";
	public static final String STRING_TYPE = "string";
	public static final String DEFAULT_AUTH_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjUwMzdjN2YzLTAzYTAtNDExMi04MTdmLTFhNmM1YTc0MzI5OSJ9.eyJzdWIiOiJzYSIsImF1ZCI6IndlYiIsIklucHV0U291cmNlIjoyLCJJbnB1dC1Vc2VyIjoxLCJpc3MiOiJGYXN0bGFuZSIsIkF1dGhQcm92aWRlciI6ImRhdGFiYXNlIiwiSW5wdXQtTG9jYXRpb24iOjAsImV4cCI6MTU5MTM4NzYxMCwiaWF0IjoxNTU5ODUxNjEwfQ.huDCOVC3YE5EvcYaLwlH8ISrKSpVSU73763ulbMGtnaqv_5vRJwxRCK_e_DQxLKPCTQz7pb-zs_BkwMiGT1I_8CzEp_4wxKkBDjuMRlpg5Y-MSMYDP-L4yLwkAy_3Hd2PnGDRkXh0IwUUnSO_vMa55hQI4BJVM63MbxIupJKCBO-apy5mY1Gzf9I_1nL9KYJsRznuFzxfaC3-YNjjcWHhvJ6sVw4rRqwPFToEv-QUe9VC1ofbJW_wCcciWOASd0Cj2zQCZ9V-TwNJpDB2MA8PjuRED4B-rS6Jvud7I-t3gddcEwLTnHEN02o8AS8PdqeLnKulBxS2uRVuABHx0c37Q";
	private static final List<String> PUBLIC_API_MAPPINGS = Collections.unmodifiableList(new ArrayList<String>() {
		{
			add(API_AUTH_ENDPOINT);
			add("/api/auth/refresh");
			add("/api/auth/locations");
			add("/api/sandbox/token/{loginName}");
			add("/api/cwp/**");
			add("/api/**");
		}
	});

	@Value("${fastlane.security.enabled:false}")
	private boolean fastLaneSecurityEnabbled;

	private ParameterBuilder parameterBuilder = new ParameterBuilder();

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public boolean supports(final DocumentationType documentationType) {
		return DocumentationType.SWAGGER_2.equals(documentationType);
	}

	@Override
	public void apply(final OperationContext context) {
		if (!fastLaneSecurityEnabbled)
			return;
		final String mapping = context.requestMappingPattern();

		if (!PUBLIC_API_MAPPINGS.stream().anyMatch(e -> antPathMatcher.match(e, mapping))) {
			final List<Parameter> parameters = new LinkedList<>();
			parameters.add(parameterBuilder.parameterType(HEADER_PARAMETER_TYPE).name(TOKEN_HEADER_NAME).modelRef(new ModelRef(STRING_TYPE)).description(HEADER_DESCRIPTION).allowMultiple(false)
					.required(true).defaultValue("Bearer " + DEFAULT_AUTH_TOKEN).build());
			context.operationBuilder().parameters(parameters);
		}
	}

}