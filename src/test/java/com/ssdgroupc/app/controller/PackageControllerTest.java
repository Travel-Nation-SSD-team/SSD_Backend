package com.ssdgroupc.app.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssdgroupc.app.entity.Package;
import com.ssdgroupc.app.repository.PackageRepository;
import com.ssdgroupc.app.service.PackageService;

@SpringBootTest
class PackageControllerTest {

	@Mock
	PackageRepository repository;

	@InjectMocks
	PackageService service;

	@Test
	void testGetAllPackage() {
		List<Package> PackageList = new ArrayList<>();
		Package p1 = new Package(1, "Hill Country Package", "invade and explore the mountain ranges", "img1","Ella/ Badulla", "Hiking/ Camping/ Mountain Climbing",10,25000.00,10);
		Package p2 = new Package(2, "Historical Package", "explore the history of Sri lanka", "img2","Dambulla", "site seeing",8,25000.00,15);

		PackageList.add(p1);
		PackageList.add(p2);

		when(repository.findAll()).thenReturn(PackageList);
		assertEquals(2, service.getAllPackages().size());
	}

	@Test
	void testGetPackage() {
		Package p = new Package(2, "Historical Package", "explore the history of Sri lanka", "img2","Dambulla", "site seeing",8,25000.00,15);
		int id = 2;
		when(repository.findById(id)).thenReturn(Optional.of(p));
		verify(repository, times(0)).findById(p.getPackage_id());
	}

	@Test
	void testAddPackage() {
		Package p = new Package(2, "Historical Package", "explore the history of Sri lanka", "img2","Dambulla", "site seeing",8,25000.00,15);

		when(repository.save(p)).thenReturn(p);
		assertEquals(p, service.addPackage(p));
	}

	@Test
	void testDeletePackage() {
		Package p = new Package(2, "Historical Package", "explore the history of Sri lanka", "img2","Dambulla", "site seeing",8,25000.00,15);

		service.deletePackage(p.getPackage_id());
		verify(repository, times(1)).deleteById(p.getPackage_id());
	}

}

