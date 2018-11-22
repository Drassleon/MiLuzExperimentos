package com.marcelo.miluz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.marcelo.miluz.MiLuzApplication;

public class ServletInitializer extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MiLuzApplication.class);
		
	}

}