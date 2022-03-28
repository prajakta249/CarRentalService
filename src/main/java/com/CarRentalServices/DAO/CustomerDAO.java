package com.CarRentalServices.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.CarRentalServices.entity.Customer;
import com.CarRentalServices.repository.AdminRepository;
import com.CarRentalServices.repository.CustomerRepository;
import com.CarRentalServices.repository.DriverRepository;
import com.CarRentalServices.repository.VehicleRepository;

@Component
public class CustomerDAO  {

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	DriverRepository driverRepo;

	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	HttpSession session;

	public void addCustomer(Customer obj) {

	  Customer newObj = customerRepo.save(obj);
	  System.out.println(newObj);
	}

	public List<Customer> getAll() {

		List<Customer> list =  customerRepo.findAll();
		return list;
	}

	public void deleteCustomer(int id) {
	
		Customer obj = customerRepo.findById(id).get();
		if(obj!=null)
		{
			customerRepo.delete(obj);
		}
		else
		{
			System.out.println("No customer found with given id");
		}
	}

	public void update(Customer obj) {
		
		Customer oldObj = customerRepo.findById(obj.getId()).get();
		
		if(oldObj!=null)
		{
			obj.setId(obj.getId());
			
			
			if(!oldObj.getCity().equals(obj.getCity()))
			{
				oldObj.setCity(obj.getCity());
			}
			if(!oldObj.getContactNo().equals(obj.getContactNo()))
			{
				oldObj.setContactNo(obj.getContactNo());
			}
			if(!oldObj.getEmail().equals(obj.getEmail()))
			{
				oldObj.setEmail(obj.getEmail());
			}
			if(!oldObj.getFirstname().equals(obj.getFirstname()))
			{
				oldObj.setFirstname(obj.getFirstname());
			}
			if(!oldObj.getUsername().equals(obj.getUsername()))
			{
				oldObj.setUsername(obj.getUsername());
			}
			if(!oldObj.getLastname().equals(obj.getLastname()))
			{
				oldObj.setLastname(obj.getLastname());
			}
			if(!(oldObj.getPincode()==(obj.getPincode())))
			{
				oldObj.setPincode(obj.getPincode());
			}
			if(!(oldObj.getState().equals(obj.getState())))
			{
				oldObj.setState(obj.getState());
			}
			customerRepo.save(oldObj);
		}
		
	}

	public boolean verify(String username, String password) {

		Customer obj = customerRepo.findCustomer(username, password);
		
		if(obj!=null)
		{
			System.out.println(obj);
			session.setAttribute("currentUser", obj.getId());
			return true;
		}
		else
		{
			return false;
		}

	}







}
