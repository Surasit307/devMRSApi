package com.app.login.login.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class LogoutIn implements Serializable {
	private static final long serialVersionUID = 1L;
	//@JsonProperty("login_id")
	//public int loginId;
	@JsonProperty("username")
	public String username;
	
	
	/*public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	
}