package com.marcelo.miluz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marcelo.miluz.MiLuzApplication;

@SpringBootApplication
public class MiLuzApplication implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(MiLuzApplication.class, args);
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String password = "123456";
		
		for(int i=0; i<1; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);

		}
	}
	
	
	
}

