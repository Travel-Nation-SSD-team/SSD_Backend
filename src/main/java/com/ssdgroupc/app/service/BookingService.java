package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Booking;
import com.ssdgroupc.app.repository.BookingRepository;


@Service
public class BookingService {

	/**
	 * Injects Bookingrepository
	 */
	@Autowired
	private BookingRepository bookingRepository;

	/**
	 * Method to save a booking
	 */
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	/**
	 * Method to get all bookings
	 */
	public List<Booking> getAllBookings() {
		List<Booking> booking = new ArrayList<>();
		bookingRepository.findAll().forEach(booking::add);
		return booking;
	}

	/**
	 * Method to get a booking
	 */
	public Optional<Booking> getBooking(int id) {
		return bookingRepository.findById(id);
	}

	/**
	 * Method to delete a booking
	 */
	public void deleteBooking(int id) {
		bookingRepository.deleteById(id);
	}
	
	/**
	 * Method to update a booking
	 */
	public Booking updateBooking(int id, Booking booking) {
		System.out.println("from service");
		System.out.println(booking.getPackage_id());
		return bookingRepository.save(booking);
	}


}
