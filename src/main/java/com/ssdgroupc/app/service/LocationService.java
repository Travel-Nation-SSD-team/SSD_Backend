package com.ssdgroupc.app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Location;
import com.ssdgroupc.app.repository.LocationRepository;

@Service
public class LocationService {

	/**
	 * Injects LocationRepository
	 */
	@Autowired
	private LocationRepository locationRepository;

	/**
	 * Method to save a Location
	 */
	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}
	/**
	 * Method to get a location
	 */
	public Optional<Location> getLocation(int id) {
		return locationRepository.findById(id);
	}

	/**
	 * Method to get all locations
	 */
	public List<Location> getAllLocations() {
		List<Location> locations = new ArrayList<>();
		locationRepository.findAll().forEach(locations::add);
		return locations;
	}

	/**
	 * Method to delete a location
	 */
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}
	
	/**
	 * Method to update a location
	 */
	public Location updateLocation(int id, Location Location) {
		return locationRepository.save(Location);
	}

}
