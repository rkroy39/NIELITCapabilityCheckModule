package com.nielit.testmodule.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class SignupBean {

	private String umane;
	private String uemail;
	private String umobile;
	private String userid;
	private String password;
	private String token;

	public String getUmane() {
		return umane;
	}

	public void setUmane(String umane) {
		this.umane = umane;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SignupBean [umane=" + umane + ", uemail=" + uemail + ", umobile=" + umobile + ", userid=" + userid
				+ ", password=" + password + ", token=" + token + "]";
	}
}
