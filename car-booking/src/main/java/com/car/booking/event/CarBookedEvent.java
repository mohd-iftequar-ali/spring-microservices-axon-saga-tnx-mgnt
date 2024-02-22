package com.car.booking.event;

import java.io.Serializable;

import com.car.booking.enums.BookingStatus;

import lombok.Data;

@Data
public class CarBookedEvent implements Serializable{

	private String carBookingId;
	private String carModelId;
	private Integer quantity;
	private String customerId;
	private Double advanceBookingPaidAmount;
	private Double totalAmount;
	private  BookingStatus bookingStatus;
}
