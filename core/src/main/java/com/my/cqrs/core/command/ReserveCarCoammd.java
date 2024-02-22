package com.my.cqrs.core.command;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class ReserveCarCoammd implements Serializable{

	@TargetAggregateIdentifier
	private  String carModelId;
	private  String carBookingId;
	private  String userId;
	private  int quantity;
	
}
