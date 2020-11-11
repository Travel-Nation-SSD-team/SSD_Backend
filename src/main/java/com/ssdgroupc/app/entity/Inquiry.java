package com.ssdgroupc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TO_INQUIRY")
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inquiry_id;
	@NotNull
	private String user_email;
	@NotNull
	private String user_mobile;
	@Column(length = 1000)
	private String inquiry_body;
	@Column(length = 1000)
	private String inquiry_answer;
	

	public Inquiry(int inquiry_id, String user_email, String user_mobile,
			String inquiry_body, String inquiry_answer) {
		super();
		this.inquiry_id = inquiry_id;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
		this.inquiry_body = inquiry_body;
		this.inquiry_answer=inquiry_answer;
	}
	
	public Inquiry() {
		super();
	}

	public int getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getInquiry_answer() {
		return inquiry_answer;
	}

	public void setInquiry_answer(String inquiry_answer) {
		this.inquiry_answer = inquiry_answer;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getInquiry_body() {
		return inquiry_body;
	}

	public void setInquiry_body(String inquiry_body) {
		this.inquiry_body = inquiry_body;
	}

	

}
