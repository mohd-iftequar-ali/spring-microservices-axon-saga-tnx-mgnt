package com.my.cqrs.core.command;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CancelCarBookingCommand implements Serializable{

	@TargetAggregateIdentifier
	private  String carBookingId;
	private  String carModelId;
	private  String userId;
	private  int quantity;
	
	
}
