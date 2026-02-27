package com.capgemini.spingbootbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;

//@SpringBootApplication
//if we will not use @springBootApplication then we need to write these three
//which ever class is @SpingBootApplication that is the entry point of our spring boot
@Configuration
@ComponentScan(basePackages = "com") 
@EnableAutoConfiguration
public class SpingbootbasicApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpingbootbasicApplication.class, args); 
		
		Doctor doc = ioc.getBean(Doctor.class);
		doc.check();
		
		EntityManagerFactory emf = ioc.getBean(EntityManagerFactory.class); 
	}

}
