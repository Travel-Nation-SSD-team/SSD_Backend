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

import com.ssdgroupc.app.entity.Location;
import com.ssdgroupc.app.service.LocationService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LocationController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects LocationService class.
	 */
	@Autowired
	private LocationService locationService;

	/**
	 * Method to get a Location
	 */
	
	@GetMapping(value = "/locations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocation(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Location> l = locationService.getLocation(id);
		if (!l.isPresent()) {
			LOGGER.info("Hotel records are empty");
			throw new NotFoundException("location record not found");
		}
		return new ResponseEntity<Location>(l.get(), HttpStatus.OK);
	}
	
	/**
	 * Method to get all Locations
	 */
	@GetMapping(value = "/locations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> getAllGalleryItems() throws NotFoundException {

		List<Location> locations = locationService.getAllLocations();

		if (locations.isEmpty()) {
			LOGGER.info("location records are empty");
			throw new NotFoundException("No location records were found");
		}

		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}

	/**
	 * Method to add a Location
	 */
	@PostMapping(value = "/locations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> addLocation(@Valid @RequestBody Location location) {

		return new ResponseEntity<Location>(locationService.addLocation(location), HttpStatus.CREATED);
	}

	/**
	 * Method to delete a Location
	 */
	@DeleteMapping("/locations/{id}")
	public ResponseEntity<Object> deleteGalleryItem(@PathVariable(value = "id") int id) {

		locationService.deleteLocation(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method to Update a Location.
	 */
	
	@PutMapping(value = "/locations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> updateLocation(@PathVariable(value = "id") int id, @Valid @RequestBody Location location) {

		return new ResponseEntity<Location>(locationService.updateLocation(id, location), HttpStatus.ACCEPTED);
	}
	


}
