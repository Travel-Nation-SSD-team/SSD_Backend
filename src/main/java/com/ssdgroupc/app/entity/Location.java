package com.ssdgroupc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TO_LOCATION")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int location_id;
	private String location_name;
	private String location_district;
	private String location_image;

	

	public Location(int location_id, String location_name, String location_district, String location_image) {
		super();
		this.location_id = location_id;
		this.location_name = location_name;
		this.location_district = location_district;
		this.location_image = location_image;
	}

	public Location() {
		super();
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getLocation_district() {
		return location_district;
	}

	public void setLocation_district(String location_district) {
		this.location_district = location_district;
	}

	public String getLocation_image() {
		return location_image;
	}

	public void setLocation_image(String location_image) {
		this.location_image = location_image;
	}
	

}
