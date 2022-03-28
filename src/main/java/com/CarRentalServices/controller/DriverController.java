package com.CarRentalServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.DriverDAO;
import com.CarRentalServices.entity.Driver;

@RestController
@RequestMapping("driver")
public class DriverController {

	@Autowired
	DriverDAO dao;
	
	@GetMapping("/getAll")
	public List<Driver> getAll()
	{
		List<Driver> list =  dao.getAll();
		return list;
	}
	
	@PostMapping("/add")
	public void addDriver(@RequestBody Driver obj)
	{
		dao.addDriver(obj);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteDriver(@PathVariable("id") String i)
	{
		int id = Integer.parseInt(i);
		dao.deleteDriver(id);
	}
	
	@PostMapping("/togglestate/{id}")
	public void toggleDriverStatus(@PathVariable("id") String i)
	{
		int id = Integer.parseInt(i);
		dao.toggleStatus(id);
	}
	
}
