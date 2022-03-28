package com.CarRentalServices.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.entity.Vehicle;
import com.CarRentalServices.repository.VehicleRepository;

@Component
public class VehicleDAO {

	@Autowired
	VehicleRepository vehicleRepo;

	public List<Vehicle> getAll() {
		
		return vehicleRepo.findAll();
	}

	public void addVehicle(Vehicle obj) {

		Vehicle vehicle =  vehicleRepo.save(obj);
		System.out.println(vehicle);
	}

	public Vehicle getById(int id) {
		
		Vehicle vehicle = vehicleRepo.findById(id).get();
		return vehicle;
	}
	
	
	
}
