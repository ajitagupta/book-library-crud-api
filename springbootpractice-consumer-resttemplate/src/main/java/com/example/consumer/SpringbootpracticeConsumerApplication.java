package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootpracticeConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpracticeConsumerApplication.class, args);
	}
	
	@Bean // this annotation helps in creating a bean during application start up, this bean scope available throught out the application
	@LoadBalanced
	public RestTemplate restTemplate() {
	return new RestTemplate();	
	}

}
