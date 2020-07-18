package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class App 
{
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		
		WebClient.Builder baseBuilder = WebClient.builder()
				.baseUrl("http://localhost:8080/sigorta/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED.toString());
		
		return baseBuilder;
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}