package com.ssdgroupc.app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Feedback;

import com.ssdgroupc.app.repository.FeedbackRepository;

import com.ssdgroupc.app.service.FeedbackService;

@SpringBootTest
class FeedbackControllerTest {

	@Mock
	private FeedbackRepository repository;

	@InjectMocks
	private FeedbackService service;

	@Test
	void getAllFeedbacksTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Feedback(2, "honeymoon package", 4, "very pleasing service","ijaz"), 
						new Feedback(1, "historical package", 5, "had a great experience","shakir"))
						.collect(Collectors.toList()));

		assertEquals(2, service.getAllFeedbacks().size());
	}

	@Test
	void addFeedbackTest() {
		Feedback feedback = new Feedback(1, "historical package", 5, "had a great experience","shakir");
		when(repository.save(feedback)).thenReturn(feedback);
		assertEquals(feedback, service.addFeedback(feedback));
	}

	@Test
	void deleteFeedbackTest() {
		Feedback feedback = new Feedback(1, "historical package", 5, "had a great experience","shakir");
		service.deleteFeedback(feedback.getFeedback_Id());
		verify(repository, times(1)).deleteById(feedback.getFeedback_Id());
	}

}

