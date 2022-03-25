package com.example.carrentalservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrentalservicee.entity.Vehicle;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Vehicle, Integer> {
	
}
