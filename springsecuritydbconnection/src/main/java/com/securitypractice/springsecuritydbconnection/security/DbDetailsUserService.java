package com.securitypractice.springsecuritydbconnection.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securitypractice.springsecuritydbconnection.entity.Account;
import com.securitypractice.springsecuritydbconnection.repo.AccountJpaRepository;

public class DbDetailsUserService implements UserDetailsService{

	private AccountJpaRepository repository;
	
	public DbDetailsUserService(AccountJpaRepository repository) {
		this.repository = repository;
	}

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Account account = repository.findByUsername(username)
		.orElseThrow(()->new RuntimeException("Username not found"));
		
		List<SimpleGrantedAuthority> authorities = new ArrayList();
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		return new User(account.getUsername(),account.getPassword(),authorities);  
	}

}
