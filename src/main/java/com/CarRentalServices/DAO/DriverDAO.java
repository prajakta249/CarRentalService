package com.CarRentalServices.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.entity.Driver;
import com.CarRentalServices.repository.DriverRepository;

@Component
public class DriverDAO {

	@Autowired
	DriverRepository driverRepo;
	
	public List<Driver> getAll() {
		
		return driverRepo.findAll();
	}

	public void addDriver(Driver obj) {

		Driver newObj =  driverRepo.save(obj);
		System.out.println(newObj);
	}

	public void deleteDriver(int id) {

		Driver obj = driverRepo.findById(id).get();
		
		if(obj!=null)
		{
			driverRepo.delete(obj);
		}
	}

	public void toggleStatus(int id) {
		
		Driver obj = driverRepo.findById(id).get();
		
		if(obj.getStatus()==1)
		{
			obj.setStatus(0);
		}
		else
		{
			obj.setStatus(1);
		}
		driverRepo.save(obj);
	}
	
}
