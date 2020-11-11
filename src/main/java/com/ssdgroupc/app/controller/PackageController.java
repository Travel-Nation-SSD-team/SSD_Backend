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
import org.springframework.web.client.HttpClientErrorException;

import com.ssdgroupc.app.entity.Package;
import com.ssdgroupc.app.service.PackageService;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PackageController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects PackageService class.
	 */
	@Autowired
	private PackageService packageService;

	/**
	 * Method to get all Package
	 */
	@GetMapping(value = "/packages", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Package>> getAllPackage() throws NotFoundException {

		List<Package> Package = packageService.getAllPackages();
		if (Package.isEmpty()) {
			LOGGER.info("Package records are empty");
			throw new NotFoundException("No Package records were found");
		}
		return new ResponseEntity<List<Package>>(Package, HttpStatus.OK);
	}

	/**
	 * Method to get a Package
	 */
	@GetMapping(value = "/packages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Package> getPackage(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Package> p = packageService.getPackage(id);
		if (!p.isPresent()) {
			LOGGER.info("Package record not found");
			throw new NotFoundException("Package record not found");
		}
		return new ResponseEntity<Package>(p.get(), HttpStatus.OK);
	}

	/**
	 * Method to add a Package
	 */
	@PostMapping(value = "/packages", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Package> addPackage(@Valid @RequestBody Package Package) {

		Optional<Package> p = packageService.getPackage(Package.getPackage_id());

		if (p.isPresent()) {
			LOGGER.error("package record already exist");
			throw new HttpClientErrorException(HttpStatus.CONFLICT,
					"package with ID" + "(" + Package.getPackage_id() + ") already exists");
		}

		return new ResponseEntity<Package>(packageService.addPackage(Package), HttpStatus.CREATED);
	}

	/**
	 * Method to update a Package
	 */
	@PutMapping(value = "/packages/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Package> updatePackage(@PathVariable(value = "id") int id, @Valid @RequestBody Package Package) {

		return new ResponseEntity<Package>(packageService.updatePackage(id, Package), HttpStatus.ACCEPTED);
	}

	/**
	 * Method to delete a Package
	 */
	@DeleteMapping("/packages/{id}")
	public ResponseEntity<Object> deletePackage(@PathVariable(value = "id") int id) {

		packageService.deletePackage(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}


}
