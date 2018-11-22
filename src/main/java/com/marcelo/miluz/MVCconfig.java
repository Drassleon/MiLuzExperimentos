package com.marcelo.miluz;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCconfig implements WebMvcConfigurer {

	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Forbidden").setViewName("Forbidden");
	}

	
	
}