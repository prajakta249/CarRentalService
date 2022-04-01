package com.CarRentalServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.LocationDAO;
import com.CarRentalServices.DTO.ILocationDTO;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationDAO dao;
	
	@GetMapping("/getLocation")
	public List<ILocationDTO> getLocation()
	{
		List<ILocationDTO> list = dao.getLocation();
		return list;
	}

}
