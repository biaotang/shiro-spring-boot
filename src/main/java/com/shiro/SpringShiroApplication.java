package com.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.DelegatingFilterProxy;

@SpringBootApplication
@ImportResource("classpath:/shiro-beans-config.xml")
public class SpringShiroApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringShiroApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringShiroApplication.class);
	}
	
	@Bean
	public FilterRegistrationBean<DelegatingFilterProxy> getShiroFilter() {
		FilterRegistrationBean<DelegatingFilterProxy> frb = new FilterRegistrationBean<DelegatingFilterProxy>(
				new DelegatingFilterProxy("shiroFilter"));
		frb.addUrlPatterns("/*");
		frb.addInitParameter("targetFilterLifecycle", "true");
		return frb;
	}
	
}
