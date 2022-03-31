package com.CarRentalServices.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.Session.Session;
import com.CarRentalServices.entity.Vehicle;
import com.CarRentalServices.repository.VehicleRepository;

@Component
public class VehicleDAO {

	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	DriverDAO driverDao;
	
	/*
	 * @Autowired Session session;
	 */
	
	public List<Vehicle> getAll() {
		
		return vehicleRepo.findAll();
	}

	public void addVehicle(Vehicle obj) {

		Vehicle vehicle =  vehicleRepo.save(obj);
		System.out.println(vehicle);
	}

	public Vehicle getById(int id, HttpSession session) {
		
		Vehicle vehicle = vehicleRepo.findById(id).get();
		if(vehicle!=null)
		{
			toogleVehicleState(vehicle.getVehicle_id());
			driverDao.assignDriver(session);
//			Session.map.put("vehicleId", vehicle.getVehicle_id());
			session.setAttribute("vehicleId", vehicle.getVehicle_id());
		}
		return vehicle;
	}
	
	public void toogleVehicleState(int id)
	{
		Vehicle vehicle = vehicleRepo.findById(id).get();
		if(vehicle!=null)
		{
			if(vehicle.getVehicle_status()==1)
			{
				vehicle.setVehicle_status(0);
			}
			else
			{
				vehicle.setVehicle_status(1);
			}
			vehicleRepo.save(vehicle);
		}
	}

	
	public List<Vehicle> getAvailableVehicle() {

		List<Vehicle> list = vehicleRepo.getAvaibleVehicle();
		
		return list;
	}
	
	
}
