package com.casestudy2_25feb;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotification implements NotificationService{

	public void sendNotification(String message) {
		System.out.println("Email sent: " + message);
		
	}
	
}