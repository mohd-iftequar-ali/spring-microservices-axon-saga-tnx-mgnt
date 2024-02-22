package com.car.inventory.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.inventory.command.CreateCarInventoryCommand;
import com.car.inventory.vo.CarInventoryVO;

@RestController
@RequestMapping("/car-inventory")
public class CarInventoryController {
	
	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String addToInventory(@RequestBody CarInventoryVO carInventoryVO) {
		carInventoryVO.setCarModelId(UUID.randomUUID().toString());
		CreateCarInventoryCommand carInventoryCommand=new CreateCarInventoryCommand();
		BeanUtils.copyProperties(carInventoryVO, carInventoryCommand);
		commandGateway.sendAndWait(carInventoryCommand);
		return carInventoryCommand.getCarModelId();
	}

}
