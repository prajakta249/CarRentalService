package com.CarRentalServices.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.CarRentalServices.entity.Feedback;
import com.CarRentalServices.repository.FeedbackRepository;

@Component
public class FeedbackDAO {

	@Autowired
	FeedbackRepository feedbackRepo;

	public void giveFeedback(Feedback obj, HttpSession session) {
		
		int bookingId = (int)session.getAttribute("bookingId");
		int customerId = (int)session.getAttribute("currentUser");

		obj.setCustomerId(customerId);
		obj.setOngoingId(bookingId);
		Feedback feedback = feedbackRepo.save(obj);
		System.out.println(feedback);
	}

	public List<Feedback> getFeedbackCustomerId(int id) {
		List<Feedback> feedback = feedbackRepo.findByCustomerId(id);

		return feedback;
	}

	public List<Feedback> getFeedbackOngoingId(int id) {
		List<Feedback> feedback = feedbackRepo.findByCustomerId(id);

		return feedback;
	}


}
