package com.my.cqrs.core.event;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CarReservedEvent implements Serializable{

	private  String carModelId;
	private  String carBookingId;
	private  String userId;
	private  int quantity;
	
}
