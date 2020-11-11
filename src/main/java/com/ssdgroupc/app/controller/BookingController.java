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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ssdgroupc.app.entity.Booking;
import com.ssdgroupc.app.service.BookingService;

import javassist.NotFoundException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BookingController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects BookingService class.
	 */
	@Autowired
	private BookingService bookingService;

	/**
	 * Method to get all Bookings
	 */
	@GetMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Booking>> getAllBookings() throws NotFoundException {

		List<Booking> booking = bookingService.getAllBookings();

		if (booking.isEmpty()) {
			LOGGER.info("Reservation records are empty");
			throw new NotFoundException("No Reservation records were found");
		}

		return new ResponseEntity<List<Booking>>(booking, HttpStatus.OK);
	}

	/**
	 * Method to get a Booking
	 * 
	 */ 
	@GetMapping(value = "/bookings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> getBooking(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Booking> b = bookingService.getBooking(id);
		if (!b.isPresent()) {
			LOGGER.info("Package record not found");
			throw new NotFoundException("Package record not found");
		}
		return new ResponseEntity<Booking>(b.get(), HttpStatus.OK);
	}

	/**
	 * Method to add a Booking
	 */
	@PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> addPackage(@Valid @RequestBody Booking booking) {

		
		return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.CREATED);
	}

	

	/**
	 * Method to delete a Booking
	 */
	@DeleteMapping("bookings/{id}")
	public ResponseEntity<Object> deleteBooking(@PathVariable(value = "id") int id) {

		bookingService.deleteBooking(id);;
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method to Update a booking.
	 */
	
	@PutMapping(value = "/bookings/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") int id, @Valid @RequestBody Booking booking) {
		return new ResponseEntity<Booking>(bookingService.updateBooking(id, booking), HttpStatus.ACCEPTED);
	}
	

}
