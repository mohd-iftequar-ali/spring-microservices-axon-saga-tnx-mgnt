package com.car.booking.command;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.car.booking.enums.BookingStatus;

import lombok.Data;

@Data
public class CreateCarBookCommand implements Serializable{

	@TargetAggregateIdentifier
	private String carBookingId;
	private String carModelId;
	private Integer quantity;
	private String customerId;
	private Double advanceBookingPaidAmount;
	private Double totalAmount;
	private  BookingStatus bookingStatus;
	
}
