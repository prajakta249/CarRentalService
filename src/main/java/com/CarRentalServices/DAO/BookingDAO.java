package com.CarRentalServices.DAO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.DTO.BookingDTO;
import com.CarRentalServices.DTO.IBookingDTO;
import com.CarRentalServices.Session.Session;
import com.CarRentalServices.entity.Booking;
import com.CarRentalServices.repository.BookingRepository;

@Component
public class BookingDAO {

	@Autowired
	BookingRepository bookingRepo;

	/*
	 * @Autowired Session session;
	 */
	public void bookRide(String time, String date, int intAmount, String source, String destination , HttpSession session ) {

		// need to make changes here after mapping

		Booking booking = new Booking();
		booking.setJourneyTime(time);
		booking.setJourneyDate(date);
		booking.setSource(source);
		booking.setDestination(destination);
		booking.setTotalPrice(intAmount);         // to be removed
		booking.setRideStatus(1);

		booking.setCustomerId((int)session.getAttribute("currentCustomer"));
		booking.setVehicleId((int)session.getAttribute("vehicleId"));
		booking.setDriverId((int)session.getAttribute("driverId"));
		booking.setPaymentId((int)session.getAttribute("paymentId"));


		/*
		 * booking.setCustomerId((int)Session.map.get("currentCustomer"));
		 * booking.setVehicleId((int)Session.map.get("vehicleId"));
		 * booking.setDriverId((int)Session.map.get("driverId"));
		 * booking.setPaymentId((int)Session.map.get("paymentId"));
		 */

		Booking newObj = bookingRepo.save(booking);
		//Session.map.put("bookingId", newObj.getId());
		session.setAttribute("bookingId", newObj.getId());
		System.out.println(newObj);
	}
	/*
	 * public void returnVehicle() {
	 * 
	 * // TODO
	 * 
	 * }
	 */

	public IBookingDTO getAllActiveRides() {

		return bookingRepo.getAllActiveRide();

	}
	
	public IBookingDTO getAllRides() {

		return bookingRepo.getAllRide();

	}
}
