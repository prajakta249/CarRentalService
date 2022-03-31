package com.CarRentalServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CarRentalServices.DTO.BookingDTO;
import com.CarRentalServices.DTO.IBookingDTO;
import com.CarRentalServices.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	@Query(value = "select concat(c.customer_firstname,\" \" , c.customer_lastname) as CustomerName, concat(v.vehicle_brand_name,\" \",v.vehicle_name) as VehicleName, concat(d.driver_firstname,\" \" , d.driver_lastname) as DriverName, p.amount, b.journey_time as JourneyTime, b.journey_date as JourneyDate, b.source as Source, b.destination as Destination, b.ride_status as RideStatus from customer_details c, vehicle v, driver_details d, booking b, payment p where b.ongoing_id=5 and d.driver_id = b.driver_id and c.customer_id = b.customer_id and v.vehicle_id = b.vehicle_id and p.payment_id = b.payment_id and b.ride_status=1", nativeQuery = true)
	public IBookingDTO getAllRide(); 
	
}
