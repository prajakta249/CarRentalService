package com.CarRentalServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CarRentalServices.DAO.PaymentDAO;
import com.CarRentalServices.entity.Payment;

@Component
public class PaymentController {

	
	@Autowired
	PaymentDAO dao;
	
	@PostMapping("/makepayment")
	public void makePayment(@RequestBody Payment obj)
	{
			//dao.makePayment(obj);
	}
	
	
	
}
