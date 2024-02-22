package com.car.inventory.event;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreateCarInventoryEvent implements Serializable{

	private String carModelId;
	private String carName;
	private String cc; 
	private String fuelType; 
	private Integer yearOfManufacture; 
	private String color; 
	private Integer inStockQuantity;
	
}
