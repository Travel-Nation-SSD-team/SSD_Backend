package com.ssdgroupc.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthPagesController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Method to get public contents.
	 */
	@GetMapping("/")
	public String allAccess() {

		LOGGER.info("Accessed with no Role");
		return "Public Content.";
	}

	/**
	 * Method to get admin contents.
	 */
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {

		LOGGER.info("Accessed with admin Role");
		return "Admin Board.";
	}
}
