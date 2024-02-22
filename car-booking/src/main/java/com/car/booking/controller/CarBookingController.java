package com.car.booking.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.booking.command.CreateCarBookCommand;
import com.car.booking.entity.repo.CarBookRepo;
import com.car.booking.vo.CarBookVO;

@RestController
@RequestMapping("/car-booking")
public class CarBookingController {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CarBookRepo bookRepo;

	@PostMapping
	public String bookCar(@RequestBody CarBookVO carBookVO) throws InterruptedException {
		carBookVO.setCarBookingId(UUID.randomUUID().toString());
		CreateCarBookCommand bookCommand = new CreateCarBookCommand();
		BeanUtils.copyProperties(carBookVO, bookCommand);
		commandGateway.sendAndWait(bookCommand);
		Thread.sleep(3000);// wait for compensating tnx completion, if error
		if (bookRepo.existsById(bookCommand.getCarBookingId())) {
			return "Car Booked with UUID : " + bookCommand.getCarBookingId();
		}
		return "Car Booking Failed";
	}

}
