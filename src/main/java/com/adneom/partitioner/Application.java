package com.adneom.partitioner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AccessPoint for the spring boot application deployment
 * 
 * @author rami.dahmouni
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan("com.adneom.partitioner.application")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}