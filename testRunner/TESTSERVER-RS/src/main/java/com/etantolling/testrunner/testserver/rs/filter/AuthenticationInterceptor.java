package com.etantolling.testrunner.testserver.rs.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.etantolling.testrunner.testserver.rs.config.SwaggerConfig;

/**
 * Intercepts Requests to set the Authentication in the SecurityContext. Sets
 * the response to 401 - Unauthorized, if the header is missing
 */
// @Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getHeader("api_key") != null) {
			String apiKey = String.valueOf(request.getHeader("api_key"));
			if (!apiKey.equals(SwaggerConfig.SWAGGER_API_KEY)) {
				log.warn("*** Wrong API_KEY: {}", apiKey);
				failAuthentication(response, "Wrong API_KEY: " + apiKey);
				return false;
			}
		} else {
			log.error("*** Missing api_key. Change this on PRODUCTION!");
			// TODO: uncomment next code:
			// failAuthentication(response, "Missing API_KEY");
			// return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// SecurityContextHolder.getContext().setAuthentication(null);
	}

	private void failAuthentication(HttpServletResponse response, String message) throws Exception {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("text/html;charset=UTF-8");

		ServletOutputStream out = response.getOutputStream();

		out.println(message);
		out.close();
	}
}