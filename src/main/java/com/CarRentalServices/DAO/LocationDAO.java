package com.CarRentalServices.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.DTO.ILocationDTO;
import com.CarRentalServices.repository.LocationRepository;
import com.CarRentalServices.repository.VehicleRepository;

@Component
public class LocationDAO {

	@Autowired
	LocationRepository locationRepo;

	public List<ILocationDTO> getLocation() {
		
		List<ILocationDTO> list = locationRepo.getLocation();
		return list;
	}
	
	
}
