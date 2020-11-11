package com.ssdgroupc.app.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssdgroupc.app.entity.Booking;
import com.ssdgroupc.app.repository.BookingRepository;
import com.ssdgroupc.app.service.BookingService;

@SpringBootTest
class BookingControllerTest {

	@Mock
	BookingRepository repository;

	@InjectMocks
	BookingService service;

	@Test
	void testGetAllBookings() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Booking(1, "pending", "ijaz", "ijaz@gmail.com", "0766470982", 1, 1 ),
						new Booking(2, "pending", "shakir", "shakir@gmail.com", "0772255242", 22, 2 ))
				.collect(Collectors.toList()));

		assertEquals(2, service.getAllBookings().size());
	}

	@Test
	void testGetBooking() {
		Booking b = new Booking(1, "pending", "ijaz", "ijaz@gmail.com", "0766470982", 1, 1);
		int id = 1;
		when(repository.findById(id)).thenReturn(Optional.of(b));
		verify(repository, times(0)).findById(b.getBooking_id());
	}

	@Test
	void testAddBooking() {
		Booking b = new Booking(1, "pending", "ijaz", "ijaz@gmail.com", "0766470982", 1, 1);
		when(repository.save(b)).thenReturn(b);
		assertEquals(b, service.addBooking(b));
	}

	@Test
	void testDeleteBooking() {
		Booking r = new Booking(1, "pending", "ijaz", "ijaz@gmail.com", "0766470982", 1, 1);
		service.deleteBooking(r.getBooking_id());
		verify(repository, times(1)).deleteById(r.getBooking_id());
	}

}


