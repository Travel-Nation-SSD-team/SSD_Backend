package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssdgroupc.app.entity.Feedback;
import com.ssdgroupc.app.repository.FeedbackRepository;
@Service
public class FeedbackService {

	/**
	 * Injects FeedbackRepository
	 */
	@Autowired
	private FeedbackRepository feedbackRepository;

	/**
	 * Method to save a Feedback to data source
	 */
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	/**
	 * Method to get all feedbacks from data source
	 */
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = new ArrayList<>();
		feedbackRepository.findAll().forEach(feedbacks::add);
		return feedbacks;
	}
	
	/**
	 * Method to get a Feedback
	 */
	public Optional<Feedback> getFeedback(int id) {
		return feedbackRepository.findById(id);
	}

	/**
	 * Method to delete a Feedback from data source
	 */
	public void deleteFeedback(int id) {
		feedbackRepository.deleteById(id);
	}

}
