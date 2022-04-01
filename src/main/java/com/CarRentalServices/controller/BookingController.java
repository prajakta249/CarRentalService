package com.CarRentalServices.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.CarRentalServices.DAO.BookingDAO;
import com.CarRentalServices.DTO.IBookingDTO;
import com.CarRentalServices.DTO.IRideDTO;

@RestController
@RequestMapping("booking")
@SessionAttributes
public class BookingController {

	
	@Autowired
	BookingDAO dao;
	
	@Autowired
	HttpServletRequest request;
	
	@PostMapping("/book/{bookingTime}/{bookingDate}/{amount}/{source}/{destination}")
	public void bookRide(@PathVariable("bookingTime") String time, @PathVariable("bookingDate") String date, @PathVariable("source") String source, @PathVariable("destination") String destination )
	{
		HttpSession session = request.getSession();
		dao.bookRide(time, date, source,destination, session);
	}
	
	@PostMapping("/book/{source}/{destination}/{journeydate}/{journeytime}")
	public void bookDetails(@PathVariable String source, @PathVariable String destination, @PathVariable String journeydate, @PathVariable String journeytime)
	{
		HttpSession session = request.getSession();
		session.setAttribute("journeyDate", journeydate);
		session.setAttribute("journeyTime", journeytime);
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		System.out.println(journeydate+" " +journeytime+" "+source+" "+destination);
		System.out.println((String)session.getAttribute("journeyTime"));
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
	public IBookingDTO getAllRides()
	{
		return dao.getAllRides();
	}
	
	@GetMapping("/getRideHistory")
	public List<IRideDTO> getRideHistory()
	{
	  List<IRideDTO> list = dao.getRideHistory(request.getSession());
	  return list;
	}
	
	
}
