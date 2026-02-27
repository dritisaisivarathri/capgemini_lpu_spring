package com.casestudy2_25feb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {
	private DeliveryService deliveryService;
	
	@Autowired
	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	public void prepareOrder() {
		deliveryService.deliverOrder(); 
	}

}