package com.etantolling.testrunner.testserver.rs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.testserver.rs.filter.AuthenticationInterceptor;

@Configuration
@ComponentScan(basePackages = { "com.etantolling.testrunner" })
public class TestServerRsConfig {
	//private static final Logger logger = LoggerFactory.getLogger(TestServerRsConfig.class);

	@Bean(name="mainDataSource")
	public JndiObjectFactoryBean mainDataSource() {
		// We only need maindb, later we can access testrepository using TESTREPOSITORY prefix in SQL queries
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/maindb");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
		return jndiObjectFB;
	}

	@Bean(name="testDataSource")
	public JndiObjectFactoryBean testDataSource() {
		// We only need maindb, later we can access testrepository using TESTREPOSITORY prefix in SQL queries
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		jndiObjectFB.setJndiName("jdbc/testrepository");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
		return jndiObjectFB;
	}
	
	@Autowired
	public MainDb setMainDataSource(@Qualifier("mainDataSource") DataSource dataSource) {
		// Force Oracle to use strict JDBC classes (e.g use java.sql.Timestamp instead oracle.sql.Timestamp
		//System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant", "true");
		MainDb.setMainDataSource(dataSource);
		return new MainDb();
	}
	
	@Autowired
	public MainDb setTestDataSource(@Qualifier("testDataSource") DataSource dataSource) {
		// Force Oracle to use strict JDBC classes (e.g use java.sql.Timestamp instead oracle.sql.Timestamp
		MainDb.setTestDataSource(dataSource);
		return new MainDb();
	}
	
	/**
	 * To add a Spring interceptor. Second, the Spring interceptors will be executed. Spring MVC provides a way to define special classes called Interceptors
	 * that gets called before and after a request is served. In this case we use an Interceptor to log all received request.
	 */
	@Bean
	public WebMvcConfigurerAdapter adapter() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new AuthenticationInterceptor());
			}
		};
	}
	
}
