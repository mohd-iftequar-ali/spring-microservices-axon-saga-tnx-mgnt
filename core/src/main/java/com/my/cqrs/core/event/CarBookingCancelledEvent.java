package com.my.cqrs.core.event;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarBookingCancelledEvent implements Serializable{

	
	private  String carModelId;
	private  String carBookingId;
	private  String userId;
	private  int quantity;
	
}
