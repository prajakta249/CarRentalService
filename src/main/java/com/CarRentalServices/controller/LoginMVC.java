package com.CarRentalServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginMVC {

	@GetMapping("/mvc")
	public String Login()
	{
//		return "./CustomerLogin/customerlogin.html";
		return "NewFile.html";
	}
}
