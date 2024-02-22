package com.car.booking.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.booking.entity.CarBook;

@Repository
public interface CarBookRepo extends JpaRepository<CarBook, String>{

}
