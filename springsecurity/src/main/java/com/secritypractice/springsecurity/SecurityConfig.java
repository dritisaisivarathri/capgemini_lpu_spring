package com.secritypractice.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		//single ton
		//builder design pattern-->object should be created as per requirements
		//httpBasic-->we are telling we are taking user name and password for our authorization
		//instead of authenticated if we use .hasRole("ADMIN")) then only with admin we can access
		//if we use .hasRole("USER)) we can access through only user
		//if we want both then use authenticated
		return http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth
				.requestMatchers("/practices").permitAll()
				.requestMatchers("/admin").authenticated())
				//.requestMatchers("/admin").hasRole("USER"))
				//.requestMatchers("/admin").hasRole("ADMIN))
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	//creating user name and password
	//{noop} encode the password
	@Bean
	public UserDetailsService getUserDetails() {
		UserDetails admin = User 
				.withUsername("admin")
				.password("{noop}1234")
				.roles("ADMIN")
				.build();
		
		UserDetails user = User
		.withUsername("yusuf")
		.password("{noop}cr4lpa")
		.roles("USER")
		.build();
		
		return new InMemoryUserDetailsManager(user,admin); 
		
	}

}
