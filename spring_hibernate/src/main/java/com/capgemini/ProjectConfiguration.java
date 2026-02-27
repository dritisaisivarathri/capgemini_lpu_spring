package com.capgemini;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.capgemini")
public class ProjectConfiguration {
	
	//@Bean
	@PostConstruct
	public EntityManager getEntityManager() {
		return Persistence
				.createEntityManagerFactory("postgres")
				.createEntityManager();
		
	} 

}
