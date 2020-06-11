package com.hxw.springboot.pojo;

import java.io.Serializable;

public class User implements Serializable {
	private String uName;

	private String uPwd;

	private String uSex;

	private String phone;

	private String uSite;

	private String manager;

	private Integer uId;

	private String uAge;

	public User(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}

	@Override
	public String toString() {
		return "User [uName=" + uName + ", uPwd=" + uPwd + ", uSex=" + uSex + ", phone=" + phone + ", uSite=" + uSite
				+ ", manager=" + manager + ", uId=" + uId + ", uAge=" + uAge + "]";
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName == null ? null : uName.trim();
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd == null ? null : uPwd.trim();
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex == null ? null : uSex.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getuSite() {
		return uSite;
	}

	public void setuSite(String uSite) {
		this.uSite = uSite == null ? null : uSite.trim();
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager == null ? null : manager.trim();
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuAge() {
		return uAge;
	}

	public void setuAge(String uAge) {
		this.uAge = uAge == null ? null : uAge.trim();
	}
}