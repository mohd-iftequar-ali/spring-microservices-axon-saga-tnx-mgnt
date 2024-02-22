package com.car.booking.aggregate;

import java.io.Serializable;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.car.booking.command.CreateCarBookCommand;
import com.car.booking.enums.BookingStatus;
import com.car.booking.event.CarBookedEvent;
import com.my.cqrs.core.command.CancelCarBookingCommand;
import com.my.cqrs.core.event.CarBookingCancelledEvent;
import com.my.cqrs.core.event.CarReservedEvent;

@Aggregate
public class CarBookAggregate {

	@AggregateIdentifier
	private String carBookingId;
	private String carModelId;
	private Integer quantity;
	private String customerId;
	private Double advanceBookingPaidAmount;
	private Double totalAmount;
	private  BookingStatus bookingStatus;
	
	
	//no arg constructor
	CarBookAggregate(){}
	
	// with command parameter
	@CommandHandler
	CarBookAggregate(CreateCarBookCommand bookCommand){
		CarBookedEvent bookedEvent=new CarBookedEvent();
		BeanUtils.copyProperties(bookCommand, bookedEvent);
		AggregateLifecycle.apply(bookedEvent);
	}
	
	@EventSourcingHandler
	public void on(CarBookedEvent bookedEvent) {
		this.carBookingId=bookedEvent.getCarBookingId();
		this.carModelId=bookedEvent.getCarModelId();
		this.customerId=bookedEvent.getCustomerId();
		this.advanceBookingPaidAmount=bookedEvent.getAdvanceBookingPaidAmount();
		this.totalAmount=bookedEvent.getTotalAmount();
	}
	
	@CommandHandler
	public void on(CancelCarBookingCommand cancelCarBookingCommand) {
		CarBookingCancelledEvent bookingCancelledEvent=new CarBookingCancelledEvent();
		BeanUtils.copyProperties(cancelCarBookingCommand, bookingCancelledEvent);
		AggregateLifecycle.apply(bookingCancelledEvent);
	}
	
	@EventSourcingHandler
	public void on(CarBookingCancelledEvent bookingCancelledEvent) {
		this.carBookingId=bookingCancelledEvent.getCarBookingId();
		this.carModelId=bookingCancelledEvent.getCarModelId();
		bookingStatus=BookingStatus.REJECTED;
	}
	
}
