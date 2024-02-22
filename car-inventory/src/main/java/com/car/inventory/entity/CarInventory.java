package com.car.inventory.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="car_inventory")
@Entity
public class CarInventory implements Serializable{

	@Id
	@Column
	private String carModelId;
	private String carName;
	private String cc; 
	private String fuelType; 
	private Integer yearOfManufacture; 
	private String color; 
	private Integer inStockQuantity;
	
}

