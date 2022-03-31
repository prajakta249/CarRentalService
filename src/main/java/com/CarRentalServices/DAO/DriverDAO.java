package com.CarRentalServices.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.Session.Session;
import com.CarRentalServices.entity.Driver;
import com.CarRentalServices.repository.DriverRepository;

@Component
public class DriverDAO {

	@Autowired
	DriverRepository driverRepo;
	
	@Autowired
	Session session;
	
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

	public void assignDriver() {

		Driver driver = driverRepo.assignDriver();
		
		if(driver!=null)
		{
			driver.setStatus(0);
			driverRepo.save(driver);
			session.map.put("driverId", driver.getId());          // TODO throw exception when no driver is availble
		}
		
	}

	public void updateDriver(Driver driver) {

		/*
		 * Driver obj = driverRepo.findById(driver.getId()).get();
		 * 
		 * if(obj!=null) { obj.setCity(driver.getCity()); }
		 */
		
		driverRepo.save(driver);         //TODO
	}
	
}
