package com.car.booking.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.booking.entity.CarBook;
import com.car.booking.entity.repo.CarBookRepo;
import com.car.booking.enums.BookingStatus;
import com.car.booking.event.CarBookedEvent;
import com.my.cqrs.core.event.CarBookingCancelledEvent;

@Component
public class CarBookingEventsHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarBookingEventsHandler.class);

	@Autowired
	private CarBookRepo carBookRepo;
	
	@EventHandler
	public void on(CarBookedEvent carBookedEvent) {
		CarBook carBook=new CarBook();
		BeanUtils.copyProperties(carBookedEvent, carBook);
		carBook.setBookingStatus(BookingStatus.CREATED);
		carBookRepo.save(carBook);
		LOGGER.info("Booked Car UUID : "+carBook.getCarBookingId()+" Model Id : "+carBook.getCarModelId());
	}
	
	@EventHandler
	public void on(CarBookingCancelledEvent bookingCancelledEvent) {
		carBookRepo.deleteById(bookingCancelledEvent.getCarBookingId());
		LOGGER.info("Car Booking Cancelled Model Id : "+bookingCancelledEvent.getCarModelId());
	}
}
