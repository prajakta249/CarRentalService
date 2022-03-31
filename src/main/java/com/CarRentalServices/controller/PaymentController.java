package com.CarRentalServices.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.CarRentalServices.repository.VehicleRepository;

@RestController
@RequestMapping("payment")
public class PaymentController {

	
	@Autowired
	PaymentDAO dao;
	
	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	LocationRepository locationRepo;
	
	@Autowired
	HttpServletRequest request;
	
	/*
	 * @Autowired Session session;
	 */
	
	@PostMapping("/makepayment")
	public void makePayment(@RequestBody Payment obj)
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
		HttpSession session = request.getSession(); 
		dao.makePayment(newObj,session);
	}
	
	// to be use somewhere
	public int calculateAmount(String source, String destination)
	{
		int distance = locationRepo.getDistance(source, destination);
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("vehicleId");
		int rate = vehicleRepo.getRate(id);
		return distance*rate;
	}
	
	
	
}
