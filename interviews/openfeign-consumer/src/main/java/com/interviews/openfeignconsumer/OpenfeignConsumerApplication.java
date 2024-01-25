package com.interviews.openfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignConsumerApplication.class, args);
	}

}
