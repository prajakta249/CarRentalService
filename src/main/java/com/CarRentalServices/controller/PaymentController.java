package com.CarRentalServices.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.PaymentDAO;
import com.CarRentalServices.Session.Session;
import com.CarRentalServices.entity.Payment;
import com.CarRentalServices.repository.LocationRepository;

@RestController
@RequestMapping("payment")
public class PaymentController {

	
	@Autowired
	PaymentDAO dao;
	
	@Autowired
	LocationRepository locationRepo;
	
	@Autowired
	Session session;
	
	@PostMapping("/makepayment")
	public void makePayment(@RequestBody Payment obj, HttpSession session)
	{
		/*
		 * int customerId =(int) Session.session.getAttribute("currentUserId"); int
		 * vehicleId =(int) Session.session.getAttribute("vehicleId");
		 */
		
		int customerId = (int)Session.map.get("currentCustomer");
		int vehicleId = (int)Session.map.get("vehicleId");
		
		Payment newObj = new Payment();
		newObj.setCustomerId(customerId);
		newObj.setVehicleId(vehicleId);
		
		dao.makePayment(newObj,session);
	}
	
	// to be use somewhere
	public int getDistance(String source, String destination)
	{
		int amount = locationRepo.getDistance(source, destination);
		return amount;
	}
	
	
	
}
