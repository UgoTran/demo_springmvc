package com.t3h.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class T3hwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(T3hwebApplication.class, args);
	}

}
