package com.ssdgroupc.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ssdgroupc.app.entity.Feedback;
import com.ssdgroupc.app.service.FeedbackService;

import javassist.NotFoundException;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FeedbackController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects FeedbackService class
	 */
	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * Method to Add a Feedback.
	 */
	
	@PostMapping(value = "/feedbacks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feedback> addHotel(@Valid @RequestBody Feedback Feedback) {

		return new ResponseEntity<Feedback>(feedbackService.addFeedback(Feedback), HttpStatus.CREATED);
	}

	/**
	 * Method to get all Feedbacks.
	 */
	@GetMapping(value = "/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Feedback>> getAllFeedbacks() throws NotFoundException {

		List<Feedback> feedbacks = feedbackService.getAllFeedbacks();

		if (feedbacks.isEmpty()) {
			LOGGER.info("Feedback records are empty");
			throw new NotFoundException("No feedback records were found");
		}

		return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
	}

	/**
	 * Method to get a Feedback
	 */
	@GetMapping(value = "/feedbacks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feedback> getFeedback(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Feedback> f = feedbackService.getFeedback(id);
		if (!f.isPresent()) {
			LOGGER.info("Package record not found");
			throw new NotFoundException("Feedback record not found");
		}
		return new ResponseEntity<Feedback>(f.get(), HttpStatus.OK);
	}

	/**
	 * Method to delete a Feedback.
	 */
	@DeleteMapping("feedbacks/{id}")
	public ResponseEntity<Object> deletFeedback(@PathVariable int id) {

		feedbackService.deleteFeedback(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
