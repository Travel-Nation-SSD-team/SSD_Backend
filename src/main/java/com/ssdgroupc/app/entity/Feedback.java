package com.ssdgroupc.app.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TO_FEEDBACKS")

public class Feedback{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedback_Id;
	private String package_name;
	@NotNull
	private int feedback_level;
	@Column(length = 100)
	private String feedback_comment;
	@NotNull
	private String username;

	public Feedback() {
		super();
	}

	public Feedback(int feedback_Id, String package_name, int feedback_level, String feedback_comment, String username) {
		super();
		this.feedback_Id = feedback_Id;
		this.package_name = package_name;
		this.feedback_level = feedback_level;
		this.feedback_comment = feedback_comment;
		this.username = username;
	}

	public int getFeedback_Id() {
		return feedback_Id;
	}

	public void setFeedback_Id(int feedback_Id) {
		this.feedback_Id = feedback_Id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public int getFeedback_level() {
		return feedback_level;
	}

	public void setFeedback_level(int feedback_level) {
		this.feedback_level = feedback_level;
	}

	public String getFeedback_comment() {
		return feedback_comment;
	}

	public void setFeedback_comment(String feedback_comment) {
		this.feedback_comment = feedback_comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}
