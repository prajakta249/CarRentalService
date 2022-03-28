package com.CarRentalServices.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.entity.Payment;
import com.CarRentalServices.repository.PaymentRepository;

@Component
public class PaymentDAO {

	
	@Autowired
	PaymentRepository paymentRepo;
	
	  public void makePayment(Payment obj) {
	  
		 
	  
	  }
	 
	
	
	
	
	
	
}
