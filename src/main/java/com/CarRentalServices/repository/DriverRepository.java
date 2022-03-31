package com.CarRentalServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CarRentalServices.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query(value ="select * from driver_details where driver_status=1 limit 1", nativeQuery = true)
	public Driver assignDriver();
	
	
	
}
