package com.CarRentalServices.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CarRentalServices.entity.Admin;
import com.CarRentalServices.repository.AdminRepository;

@Component
public class AdminDAO {
	
	
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	HttpSession session;

	public boolean verify(String username, String password) {

		Admin obj = adminRepo.findAdmin(username, password);
		if(obj!=null)
		{
			session.setAttribute("currentAdminId", obj.getId());
			return true;
		}
		else
		{
			return false;
		}
	}

	public void addAdmin(Admin admin) {

	
		Admin obj =  adminRepo.save(admin);
		System.out.println(obj);
		
	}

	public List<Admin> getAll() {
		
		return adminRepo.findAll();
	}
	
	
}
