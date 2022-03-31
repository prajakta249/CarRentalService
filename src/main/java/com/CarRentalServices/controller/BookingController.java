package com.CarRentalServices.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.BookingDAO;
import com.CarRentalServices.DTO.IBookingDTO;

@RestController
@RequestMapping("booking")
public class BookingController {

	
	@Autowired
	BookingDAO dao;
	
	@PostMapping("/book/{bookingTime}/{bookingDate}/{amount}/{source}/{destination}")
	public void bookRide(@PathVariable("bookingTime") String time, @PathVariable("bookingDate") String date, @PathVariable("amount") String amount, @PathVariable("source") String source, @PathVariable("destination") String destination, HttpSession session )
	{
		int intAmount = Integer.parseInt(amount);
		dao.bookRide(time, date, intAmount, source,destination,session);
	}
	
	/*
	 * @PostMapping("/returnVehicle") public void returnVehicle() {
	 * dao.returnVehicle(); }
	 */
	
	@GetMapping("/getAllActiveRides")
	public IBookingDTO getAllActiveRides()
	{
		 return dao.getAllActiveRides();
	}
	
	@GetMapping("/getAll")
	public void getAllRides()
	{
		
	}
	
	
}
