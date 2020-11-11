package com.ssdgroupc.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ssdgroupc.app.entity.Hotel;
import com.ssdgroupc.app.service.HotelService;

import javassist.NotFoundException;


@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
public class HotelController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Injects HotelService class.
	 */
	@Autowired	
	private HotelService HotelService;
	
	/**
	 * Method to get a Hotel
	 */
	@GetMapping(value = "/hotels/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> getHotel(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Hotel> h = HotelService.getHotel(id);
		if (!h.isPresent()) {
			LOGGER.info("Hotel records are empty");
			throw new NotFoundException("hotel record not found");
		}
		return new ResponseEntity<Hotel>(h.get(), HttpStatus.OK);
	}
	
	/**
	 * Method to Get all hotel.
	 */
	
	@GetMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> getHotels() throws NotFoundException {

		List<Hotel> hotel = HotelService.getHotels();

		if (hotel.isEmpty()) {
			throw new NotFoundException("No Hotels records were found");
		}

		return new ResponseEntity<List<Hotel>>(hotel, HttpStatus.OK);
	}
	
	/**
	 * Method to Add a hotel.
	 */
	
	@PostMapping(value = "/hotels", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) {

		return new ResponseEntity<Hotel>(HotelService.addHotel(hotel), HttpStatus.CREATED);
	}
	
	/**
	 * Method to Update a hotel.
	 */
	
	@PutMapping(value = "/hotels/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") int id, @Valid @RequestBody Hotel hotel) {

		return new ResponseEntity<Hotel>(HotelService.updateHotel(id, hotel), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Method to Delete a hotel.
	 */
	@DeleteMapping("/hotels/{id}")
	public ResponseEntity<Object> deleteHotel(@PathVariable(value = "id") int id) {

		HotelService.deleteHotel(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
