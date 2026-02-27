package com.casestudy2_25feb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	private NotificationService notificationService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	public OrderService(@Qualifier("smsNotification") NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	public void placeOrder() {
		restaurantService.prepareOrder();
		notificationService.sendNotification("Food arrived");
	}

}
