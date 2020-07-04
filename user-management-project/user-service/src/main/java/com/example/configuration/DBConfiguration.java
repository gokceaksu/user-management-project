package com.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
	
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("dev");
		return "dev";
	}
	
	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("test");
		return "test";
	}
	
	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println("prod");
		return "prod";
	}
	
}
