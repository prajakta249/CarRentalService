package com.example.carrentalservicee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrentalservice.Repository;
import com.example.carrentalservicee.entity.Vehicle;

@RestController
public class Controllers {

	@Autowired
	Repository repo; 
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}

	@GetMapping("/getVehicleDetails")
	public List<Vehicle> getVehicleDetails() {
		List<Vehicle> list = repo.findAll();
		for (Vehicle vehicle : list) {
			System.out.print(vehicle);
		}
		return list;
	}
} //end of Class Controllers
