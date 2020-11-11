package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Hotel;
import com.ssdgroupc.app.repository.HotelRepository;


@Service
public class HotelService {
	
	@Autowired
	private HotelRepository HotelRepository;
	
	public Optional<Hotel> getHotel(int id) {
		return HotelRepository.findById(id);
	}
	
	public List<Hotel> getHotels() {
		List<Hotel> Hotels = new ArrayList<>();
		HotelRepository.findAll().forEach(Hotels::add);
		return Hotels;
	}
	
	public Hotel addHotel(Hotel Hotel) {
		return HotelRepository.save(Hotel);
	}
	
	public Hotel updateHotel(int id, Hotel Hotel) {
		return HotelRepository.save(Hotel);
	}
	
	public void deleteHotel(int id) {
		HotelRepository.deleteById(id);
	}
}
