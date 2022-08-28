package com.app.login.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer loginId;
	public String username;
	private String status_login;
	private Timestamp token;
	private Timestamp date;
	
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus_login() {
		return status_login;
	}
	public void setStatus_login(String status_login) {
		this.status_login = status_login;
	}
	public Timestamp getToken() {
		return token;
	}
	public void setToken(Timestamp token) {
		this.token = token;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
	
	
	
	
	
	
	
	
}
