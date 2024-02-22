package com.car.inventory.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarInventoryVO implements Serializable{

	private String carModelId;
	private String carName;
	private String cc; 
	private String fuelType; 
	private Integer yearOfManufacture; 
	private String color; 
	private Integer inStockQuantity;
	
}
