package com.CarRentalServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CarRentalServices.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
	
}
