package org.han.vo;

import java.util.Date;

public class UserVO {
	
	private String userid;
	private String password;
	private String username;
	private String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", password=" + password
				+ ", username=" + username + ", email=" + email + "]";
	}
	
	

}
