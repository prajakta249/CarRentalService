package com.CarRentalServices.DAO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.Session.Session;
import com.CarRentalServices.entity.Payment;
import com.CarRentalServices.repository.PaymentRepository;

@Component
public class PaymentDAO {

	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	BookingDAO bookingdao;
	
	/*
	 * @Autowired Session session;
	 */
	
	
	  public void makePayment(Payment obj, HttpSession session) {
		  
		  Payment newObj =  paymentRepo.save(obj);
		  System.out.println(newObj);
//		  Session.map.put("paymentId", newObj.getId());
		  session.setAttribute("paymentId", newObj.getId());
		  bookingdao.bookRide(session);
	  }
	
	
	
}
