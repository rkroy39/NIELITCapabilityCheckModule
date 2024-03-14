package com.nielit.testmodule.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "signup")
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long signupid;
	private String username;
	private String mobile;
	private String email;
	private String userid;
	private String password;
	private Boolean iscompleted;
	private Date created_at;
	private Date updated_at;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Long getSignupid() {
		return signupid;
	}

	public void setSignupid(Long signupid) {
		this.signupid = signupid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIscompleted() {
		return iscompleted;
	}

	public void setIscompleted(Boolean iscompleted) {
		this.iscompleted = iscompleted;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

}
