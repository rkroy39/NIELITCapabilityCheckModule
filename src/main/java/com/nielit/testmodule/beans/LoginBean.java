package com.nielit.testmodule.beans;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {

	private String loginid;
	private String password;
	private String logintoken;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogintoken() {
		return logintoken;
	}

	public void setLogintoken(String logintoken) {
		this.logintoken = logintoken;
	}
}
