package com.varun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
			
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Loans2Application {

	public static void main(String[] args) {
		SpringApplication.run(Loans2Application.class, args);
	}

}
