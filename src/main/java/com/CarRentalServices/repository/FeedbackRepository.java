package com.CarRentalServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CarRentalServices.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query(value="select * from feedback f where f.customer_id =:id", nativeQuery = true)
	public List<Feedback> findByCustomerId(@Param("id") int id);
	
	@Query(value="select * from feedback f where f.ongoing_id =:id", nativeQuery = true)
	public List<Feedback> findByOngoingId(@Param("id") int id);
	
	
}
