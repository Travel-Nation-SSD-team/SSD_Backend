package com.ssdgroupc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "TO_BOOKING")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Booking_id;
	@NotNull
	private String booking_confirmation;
	@NotNull
	private String username;
	@NotNull
	private String email;
	@NotNull
	private String mobile;
	@NotNull
	private int Package_id;
	@NotNull
	private int hotel_id;
	

	

	public Booking(int Booking_id, String booking_confirmation, String username, String email,
			String mobile,int Package_id,int hotel_id) {
		super();
		this.Booking_id = Booking_id;
		this.booking_confirmation = booking_confirmation;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.Package_id = Package_id;
		this.hotel_id= hotel_id;
		
	}
	
	public Booking() {
		super();
	}

	public int getBooking_id() {
		return Booking_id;
	}

	public void setBooking_id(int booking_id) {
		Booking_id = booking_id;
	}

	public String getBooking_confirmation() {
		return booking_confirmation;
	}

	public void setBooking_confirmation(String booking_confirmation) {
		this.booking_confirmation = booking_confirmation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getPackage_id() {
		return Package_id;
	}

	public void setPackage_id(int Package_id) {
		this.Package_id = Package_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	

	

}
