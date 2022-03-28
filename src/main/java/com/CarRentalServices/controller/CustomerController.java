package com.CarRentalServices.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.CustomerDAO;
import com.CarRentalServices.entity.Customer;
import com.CarRentalServices.repository.AdminRepository;
import com.CarRentalServices.repository.CustomerRepository;
import com.CarRentalServices.repository.DriverRepository;
import com.CarRentalServices.repository.VehicleRepository;

@RestController
@RequestMapping("carrentalservices")
public class CustomerController {
	
	@Autowired
	CustomerDAO dao;
	@Autowired
	HttpSession session;
	
	@GetMapping("/verify/{username}/{password}")
	public boolean verifyCustomer(@PathVariable String username, @PathVariable String password)
	{
		boolean status = false;
		status = dao.verify(username, password);
		return status;
	}
	
	@PostMapping("/add")
	public void addCustomer(@RequestBody Customer obj)
	{
		dao.addCustomer(obj);
		System.out.println(obj);
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomer()
	{
		return dao.getAll();
	}
	
	@PostMapping("/deletecustomer/{id}")
	public void deleteCustomer(@RequestParam String i)
	{
		int id = Integer.parseInt(i);
		dao.deleteCustomer(id);
	}
	
	
	@PostMapping("/update")
	public void updateCustomer(@RequestBody Customer obj)
	{
		dao.update(obj);
	}
	
	
	
	
}
