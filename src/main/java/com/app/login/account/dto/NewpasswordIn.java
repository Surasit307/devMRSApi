package com.app.login.account.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class NewpasswordIn implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("username")
	public String username;
	@JsonProperty("password")
	public String password;
	@JsonProperty("newpassword")
	private String newpassword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	

	
}
	
