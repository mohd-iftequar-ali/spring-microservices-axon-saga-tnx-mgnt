package com.car.inventory.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.car.inventory.command.CreateCarInventoryCommand;
import com.car.inventory.event.CreateCarInventoryEvent;
import com.my.cqrs.core.command.ReserveCarCoammd;
import com.my.cqrs.core.event.CarReservedEvent;

@Aggregate
public class CarInventoryAggregate {

	@AggregateIdentifier
	private String carModelId; 
	private String carName;
	private String cc; 
	private String fuelType; 
	private Integer yearOfManufacture; 
	private String color; 
	private Integer inStockQuantity;
	
	// no arg constructor
	CarInventoryAggregate(){}
	
	//create command arg constructor
	@CommandHandler
	CarInventoryAggregate(CreateCarInventoryCommand carInventoryCommand){
		CreateCarInventoryEvent carInventoryEvent=new CreateCarInventoryEvent();
		BeanUtils.copyProperties(carInventoryCommand, carInventoryEvent);
		AggregateLifecycle.apply(carInventoryEvent);
	}
	
	@EventSourcingHandler
	public void on(CreateCarInventoryEvent carInventoryEvent) {
		this.carModelId=carInventoryEvent.getCarModelId();
		this.cc=carInventoryEvent.getCc();
		this.fuelType=carInventoryEvent.getFuelType();
		this.yearOfManufacture=carInventoryEvent.getYearOfManufacture();
		this.color=carInventoryEvent.getColor();
		this.inStockQuantity=carInventoryEvent.getInStockQuantity();
	}
	
	@CommandHandler
	public void on(ReserveCarCoammd reserveCarCoammd) {
		if(reserveCarCoammd.getQuantity()>inStockQuantity) {	
			throw new IllegalArgumentException("in sufficient numbers of items in stock");
		}
		CarReservedEvent carReservedEvent=new CarReservedEvent();
		BeanUtils.copyProperties(reserveCarCoammd, carReservedEvent);
		AggregateLifecycle.apply(carReservedEvent);
	}
	
	@EventSourcingHandler
	public void on(CarReservedEvent carReservedEvent) {
		this.inStockQuantity-=carReservedEvent.getQuantity();
	}
	
}
