package com.ssdgroupc.app.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name = "TO_HOTEL")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotel_id;
	private String hotel_name;
	private String hotel_location;
	@NotNull
	@Column(length = 1000)
	private String hotel_address;
	private int rooms_available;
	private String hotel_image;
	
	public Hotel(int hotel_id, String hotel_name, String hotel_location,  String hotel_address, int rooms_available, String hotel_image) {
		super();
		this.hotel_id=hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_location = hotel_location;
		this.hotel_address = hotel_address;
		this.rooms_available = rooms_available;
		this.hotel_image = hotel_image;
	}
	
	public Hotel() {
		super();
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public int getRooms_available() {
		return rooms_available;
	}

	public void setRooms_available(int rooms_available) {
		this.rooms_available = rooms_available;
	}

	public String getHotel_image() {
		return hotel_image;
	}

	public void setHotel_image(String hotel_image) {
		this.hotel_image = hotel_image;
	}
	
	

}


