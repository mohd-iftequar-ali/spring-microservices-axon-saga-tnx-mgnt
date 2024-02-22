package com.car.inventory.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.inventory.entity.CarInventory;

@Repository
public interface CarInventoryRepo extends JpaRepository<CarInventory, String>{

}
