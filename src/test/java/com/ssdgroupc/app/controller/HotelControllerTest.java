package com.ssdgroupc.app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssdgroupc.app.entity.Hotel;
import com.ssdgroupc.app.repository.HotelRepository;
import com.ssdgroupc.app.service.HotelService;

@SpringBootTest
class HotelControllerTest {

	@Mock
	private HotelRepository repository;

	@InjectMocks
	private HotelService service;

	@Test
	void getAllHotelsTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Hotel(1, "Kingsbury", "Colombo", "48 Janadhipathi Mawatha, Colombo",25,"https://pix10.agoda.net/hotelImages/66612/-1/2d77500935ebf62e754389b307599f02.jpg?s=1024x768"),
						new Hotel(3, "Mountain Heaven Hotel", "Ella", "Kitalella, Ella 90090",25,"https://cf.bstatic.com/images/hotel/max1280x900/168/168858734.jpg"))
						.collect(Collectors.toList()));

		assertEquals(2, service.getHotels().size());
	}
	
	@Test
	void testGetHotel() {
		Hotel h = new Hotel(3, "Mountain Heaven Hotel", "Ella", "Kitalella, Ella 90090",25,"https://cf.bstatic.com/images/hotel/max1280x900/168/168858734.jpg");
		int id = 3;
		when(repository.findById(id)).thenReturn(Optional.of(h));
		verify(repository, times(0)).findById(h.getHotel_id());
	}


	@Test
	void addHotelTest() {
		Hotel hotel = new Hotel(3, "Mountain Heaven Hotel", "Ella", "Kitalella, Ella 90090",25,"https://cf.bstatic.com/images/hotel/max1280x900/168/168858734.jpg");
		when(repository.save(hotel)).thenReturn(hotel);
		assertEquals(hotel, service.addHotel(hotel));
	}

	@Test
	void deleteHotelTest() {
		Hotel hotel = new Hotel(3, "Mountain Heaven Hotel", "Ella", "Kitalella, Ella 90090",25,"https://cf.bstatic.com/images/hotel/max1280x900/168/168858734.jpg");
		service.deleteHotel(hotel.getHotel_id());
		verify(repository, times(1)).deleteById(hotel.getHotel_id());
	}

}

