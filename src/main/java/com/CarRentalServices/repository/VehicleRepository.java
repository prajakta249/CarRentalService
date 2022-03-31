package com.CarRentalServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CarRentalServices.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	
	@Query(value = "select * from vehicle where vehicle_status =1", nativeQuery = true)
	public List<Vehicle> getAvaibleVehicle();

	@Query(value="select vehicle_price_per_km from vehicle where vehicle_id =:id ", nativeQuery = true)
	public int getRate(@Param("id")int id);
	
}
