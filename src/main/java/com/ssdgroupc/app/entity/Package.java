package com.ssdgroupc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TO_PACKAGE")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Package_id;
	@NotNull
	private String Package_name;
	@NotNull
	@Column(length = 3000)
	private String Package_description;
	@NotNull
	@Column(length = 500)
	private String Package_image;
	@NotNull
	@Column(length = 250)
	private String Package_locations;
	@NotNull
	@Column(length = 250)
	private String Package_activities;
	@NotNull
	private int Package_Days;
	@NotNull
	private double Package_price;
	@NotNull
	private int Package_participants;
	
	
	

	


	public Package(int Package_id,String Package_name,String Package_description,
			String Package_image,String Package_locations, String Package_activities,
			int Package_Days, double Package_price, int Package_participants) {
		super();
		this.Package_id = Package_id;
		this.Package_name = Package_name;
		this.Package_description = Package_description;
		this.Package_image = Package_image;
		this.Package_locations = Package_locations;
		this.Package_activities = Package_activities;
		this.Package_Days = Package_Days;
		this.Package_price = Package_price;
		this.Package_participants = Package_participants;
	}
	
	public Package() {
		super();
	}

	public int getPackage_id() {
		return Package_id;
	}

	public void setPackage_id(int package_id) {
		Package_id = package_id;
	}

	public String getPackage_name() {
		return Package_name;
	}

	public void setPackage_name(String package_name) {
		Package_name = package_name;
	}

	public String getPackage_description() {
		return Package_description;
	}

	public void setPackage_description(String package_description) {
		Package_description = package_description;
	}

	public String getPackage_image() {
		return Package_image;
	}

	public void setPackage_image(String package_image) {
		Package_image = package_image;
	}

	public String getPackage_locations() {
		return Package_locations;
	}

	public void setPackage_locations(String package_locations) {
		Package_locations = package_locations;
	}

	public String getPackage_activities() {
		return Package_activities;
	}

	public void setPackage_activities(String package_activities) {
		Package_activities = package_activities;
	}

	public int getPackage_Days() {
		return Package_Days;
	}

	public void setPackage_Days(int package_Days) {
		Package_Days = package_Days;
	}

	public double getPackage_price() {
		return Package_price;
	}

	public void setPackage_price(double package_price) {
		Package_price = package_price;
	}

	public int getPackage_participants() {
		return Package_participants;
	}

	public void setPackage_participants(int package_participants) {
		Package_participants = package_participants;
	}

	
}
