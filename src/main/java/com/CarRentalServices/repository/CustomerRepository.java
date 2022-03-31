package com.CarRentalServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CarRentalServices.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from customer_details a where a.customer_username=:username and a.customer_password=:password limit 1", nativeQuery = true )
	public Customer findCustomer(@Param("username") String username, @Param("password") String password);
	

}
