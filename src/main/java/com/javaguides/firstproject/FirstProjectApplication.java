package com.javaguides.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@SpringBootConfiguration
public class FirstProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstProjectApplication.class, args);
	}


}
