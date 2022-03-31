package com.CarRentalServices.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.AdminDAO;
import com.CarRentalServices.entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {


	@Autowired
	AdminDAO dao;
	@Autowired
	HttpSession session;

	@GetMapping("/verify/{username}/{password}")
	public boolean verifyAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {

		boolean status = dao.verify(username, password);
		
		return status;
	}
	
	@PostMapping("/addadmin")
	public void addAdmin(@RequestBody Admin admin)
	{
		dao.addAdmin(admin);
	}
	
	@GetMapping("/getAll")
	public List<Admin> getAdmin()
	{
		List<Admin> list =  dao.getAll();
		return list;
	}

}
