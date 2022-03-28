package com.CarRentalServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CarRentalServices.entity.Admin;
import com.CarRentalServices.entity.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	
	@Query(value="select * from admin_credentials a where a.admin_username=:username and a.admin_password=:password", nativeQuery = true )
	public Admin findAdmin(@Param("username") String username, @Param("password") String password);

}
