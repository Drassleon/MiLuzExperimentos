package com.marcelo.miluz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marcelo.miluz.auth.handler.LoginSuccess;
import com.marcelo.miluz.models.service.impl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class ConfiguracionSpringSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired 
	private LoginSuccess successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/", "/css/**", "**/js/**", "/images/**")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		    .formLogin()
		    .successHandler(successHandler)
		        .loginPage("/login")
		    .permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/Forbidden");
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}