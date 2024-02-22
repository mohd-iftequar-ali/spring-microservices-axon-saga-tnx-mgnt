package com.car.inventory.command;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CreateCarInventoryCommand implements Serializable{

	@TargetAggregateIdentifier
	private String carModelId;
	private String carName;
	private String cc; 
	private String fuelType; 
	private Integer yearOfManufacture; 
	private String color; 
	private Integer inStockQuantity;
	
}
