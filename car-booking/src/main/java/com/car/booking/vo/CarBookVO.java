package com.car.booking.vo;

import java.io.Serializable;

import com.car.booking.enums.BookingStatus;

import lombok.Data;

@Data
public class CarBookVO implements Serializable{

	private String carBookingId;	
	private String carModelId;
	private Integer quantity;
	private String customerId;
	private Double advanceBookingPaidAmount;
	private Double totalAmount;
	private  BookingStatus bookingStatus;
}
