package com.car.inventory.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.inventory.entity.CarInventory;
import com.car.inventory.entity.repo.CarInventoryRepo;
import com.car.inventory.event.CreateCarInventoryEvent;
import com.my.cqrs.core.event.CarReservedEvent;

@Component
public class CarInventoryEventsHandler {

	@Autowired
	private CarInventoryRepo carInventoryRepo;
	
	@EventHandler
	public void on(CreateCarInventoryEvent carInventoryEvent) {
		CarInventory carInventory=new CarInventory();
		BeanUtils.copyProperties(carInventoryEvent, carInventory);
		carInventoryRepo.save(carInventory);
	}
	
	
	// update quantity in car inventory table
	@EventHandler
	public void on(CarReservedEvent carReservedEvent) {
		CarInventory carInventory=carInventoryRepo.findById(carReservedEvent.getCarModelId()).get();
		Integer currentQuantity=carInventory.getInStockQuantity()-carReservedEvent.getQuantity();
		carInventory.setInStockQuantity(currentQuantity);
		carInventoryRepo.save(carInventory);
	}
}
