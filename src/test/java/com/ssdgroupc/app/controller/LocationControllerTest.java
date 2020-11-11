package com.ssdgroupc.app.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssdgroupc.app.entity.Location;
import com.ssdgroupc.app.repository.LocationRepository;
import com.ssdgroupc.app.service.LocationService;

@SpringBootTest
class LocationControllerTest {

	@Mock
	LocationRepository repository;

	@InjectMocks
	LocationService service;

	@Test
	void testGetAllLocations() {
		List<Location> LocationList = new ArrayList<>();
		Location l1 = new Location(1,"Sera Ella","Matale","seraella.jpg");
		Location l2 = new Location(2,"Nine arches bridge","Ella","ella.jpg");

		LocationList.add(l1);
		LocationList.add(l2);

		when(repository.findAll()).thenReturn(LocationList);
		assertEquals(2, service.getAllLocations().size());
	}


	@Test
	void testAddLocation() {
		Location l = new Location(1,"Sera Ella","Matale","seraella.jpg");

		when(repository.save(l)).thenReturn(l);
		assertEquals(l, service.addLocation(l));
	}

	@Test
	void testDeleteLocation() {
		Location l = new Location(1,"Sera Ella","Matale","seraella.jpg");

		service.deleteLocation(l.getLocation_id());
		verify(repository, times(1)).deleteById(l.getLocation_id());
	}

}

