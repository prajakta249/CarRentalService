package com.CarRentalServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRentalServices.DAO.FeedbackDAO;
import com.CarRentalServices.entity.Feedback;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackDAO dao;
	
	@PostMapping("/add")
	public void giveFeedback(@RequestBody Feedback obj)
	{
		dao.giveFeedback(obj); 
	}
	
	@GetMapping("/getFeedbackCustomerId/{id}")
	public List<Feedback> getFeedbackByCustomer(@PathVariable("id") String i)
	{
		int id = Integer.parseInt(i);
		List<Feedback> feedback = dao.getFeedbackCustomerId(id);
		return feedback;
	}
	
	@GetMapping("/getFeedbackOngoingId/{id}")
	public List<Feedback> getFeedbackByRide(@PathVariable("id") String i)
	{
		int id = Integer.parseInt(i);
		List<Feedback> feedback = dao.getFeedbackCustomerId(id);
		return feedback;
	}
	
}
