package com.car.booking.entity;

import java.io.Serializable;

import com.car.booking.enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="car_booking")
@Data
public class CarBook implements Serializable{

	@Id
	@Column	
	private String carBookingId;
	@Column
	private String carModelId;
	private Integer quantity;
	private String customerId;
	private Double advanceBookingPaidAmount;
	private Double totalAmount;
	@Enumerated(EnumType.STRING)
	private  BookingStatus bookingStatus;
}
