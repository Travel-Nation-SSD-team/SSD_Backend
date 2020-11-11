package com.ssdgroupc.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelNationApi {

	private static final Logger LOGGER = LogManager.getLogger(TravelNationApi.class);

	/**
	 * Main method of the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(TravelNationApi.class, args);
		LOGGER.info("Application Started");

	}

}