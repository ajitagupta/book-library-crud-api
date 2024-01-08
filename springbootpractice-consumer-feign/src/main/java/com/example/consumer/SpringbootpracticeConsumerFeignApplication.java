package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootpracticeConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpracticeConsumerFeignApplication.class, args);
	}

}
