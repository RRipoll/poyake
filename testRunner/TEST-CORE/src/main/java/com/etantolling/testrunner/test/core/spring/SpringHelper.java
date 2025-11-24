package com.etantolling.testrunner.test.core.spring;


import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.web.ServletContextApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class SpringHelper {
	private static ConfigurableApplicationContext _context;

	private static final Logger log = LoggerFactory.getLogger(SpringHelper.class);

	public static void setContext(ConfigurableApplicationContext context) {
		_context = context;
	}

	public static ConfigurableApplicationContext getContext() {
		return _context;
	}

	public static <T> T getBean(Class<T> bean) {
		try {
			return _context.getBean(bean);
		}
		catch (Exception ex) {
			log.error("*** bean does not exist, but I'll create one: " + bean.getName());
			try {
				// if the object does not exist => create one and return it by the way
				return bean.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				//log.error("ERROR STACKTRACE: ", e);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				log.error("ERROR STACKTRACE: ", e);
			}
		}
		return null;
	}

	public static Object getBean(String beanName) throws Exception {
		try {
			return  _context.getBean(beanName);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	
	
	public static void initSpring(DataSource dataSource, Object... sources) throws Exception {
		System.getProperties().setProperty("oracle.jdbc.J2EE13Compliant", "true");

		log.info("***************** Start Spring *****************");
		if (dataSource != null) {
			log.info("*** Datasource received:" + dataSource);
			DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
			parentBeanFactory.setAllowEagerClassLoading(false);
			parentBeanFactory.registerSingleton("dataSource", dataSource);
			GenericApplicationContext parentContext = new GenericApplicationContext(parentBeanFactory);
			parentContext.refresh();

			SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(sources).parent(parentContext).web(false);
			appBuilder.profiles(SpringProfileSelector.buildSpringProfileName());
			_context = appBuilder.run(new String[0]);
		} else {
			SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(sources).web(false);
			appBuilder.profiles(SpringProfileSelector.buildSpringProfileName());
			// appBuilder.application().setAdditionalProfiles(SpringProfileSelector.buildSpringProfileName());
			_context = appBuilder.run(new String[0]);
			new SpringEnvironmentUtils().logEnvironment(_context.getEnvironment());
			MainDb.setMainDataSource(_context.getBean(DataSource.class));
		}
//		log.info("*** All beans loaded: " + Arrays.asList(_context.getBeanDefinitionNames()));
		log.info("***************** End Spring *****************");
	}

	public static void initSpringWeb(DataSource dataSource, ServletContext sc, Object... sources) throws Exception {
		log.info("*** Datasource received:" + dataSource);
		DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
		if (dataSource != null) {
			parentBeanFactory.registerSingleton("dataSource", dataSource);
		}
		GenericApplicationContext parentContext = new GenericApplicationContext(parentBeanFactory);
		parentContext.refresh();

		SpringApplicationBuilder builder = new SpringApplicationBuilder(sources);
		builder.initializers(new ServletContextApplicationContextInitializer(sc));
		builder.contextClass(AnnotationConfigEmbeddedWebApplicationContext.class);

		_context = builder.parent(parentContext).run(new String[0]);
		log.info("*** Datasource used:" + _context.getBean(DataSource.class));

		sc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, _context);

//		log.info("*** All beans loaded: " + Arrays.asList(_context.getBeanDefinitionNames()));
		log.info("***************** End Spring *****************");
	}

}
