package com.ssdgroupc.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Inquiry;
import com.ssdgroupc.app.repository.InquiryRepository;
import com.ssdgroupc.app.service.InquiryService;

@SpringBootTest
class InquiryControllerTest {

	@Mock
	InquiryRepository repository;

	@InjectMocks
	InquiryService service;

	@Test
	void testGetAllInquires() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Inquiry(1,  "ijaz@gmail.com", "0766470982", "legal requiremnts of overseas customers","inquiry answer"),
						new Inquiry(2, "shakir@gmail.com", "0772255242", "package availability","inquiry answer"))
				.collect(Collectors.toList()));

		assertEquals(2, service.getAllInquires().size());
	}

	@Test
	void testAddInquiry() {
		Inquiry i = new Inquiry(1,  "ijaz@gmail.com", "0766470982", "legal requiremnts of overseas customers","inquiry answer");
		when(repository.save(i)).thenReturn(i);
		assertEquals(i, service.addInquiry(i));
	}

	@Test
	void testDeleteInquiry() {
		Inquiry i = new Inquiry(1,  "ijaz@gmail.com", "0766470982", "legal requiremnts of overseas customers","inquiry answer");
		service.deleteInquiry(i.getInquiry_id());
		verify(repository, times(1)).deleteById(i.getInquiry_id());
	}
	

}

