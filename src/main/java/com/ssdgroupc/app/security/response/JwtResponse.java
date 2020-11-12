package com.ssdgroupc.app.security.response;

import java.util.List;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private long user_id;
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, long user_id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
