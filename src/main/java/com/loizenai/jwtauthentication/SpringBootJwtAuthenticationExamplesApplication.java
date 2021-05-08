package com.loizenai.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJwtAuthenticationExamplesApplication {

	public static void main(String[] args) {
		System.setProperty("java.runtime.version","11");
		SpringApplication.run(SpringBootJwtAuthenticationExamplesApplication.class, args);
	}

}
