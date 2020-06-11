package com.hxw.springboot.pojo;

import java.io.Serializable;

public class Supplier implements Serializable {
	private Integer sId;

	private String supName;

	private String intro;

	private String contacts;

	private String phone;

	private String site;

	private String faxes;

	public Supplier() {
		super();
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName == null ? null : supName.trim();
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro == null ? null : intro.trim();
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts == null ? null : contacts.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site == null ? null : site.trim();
	}

	public String getFaxes() {
		return faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes == null ? null : faxes.trim();
	}

	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", supName=" + supName + ", intro=" + intro + ", contacts=" + contacts
				+ ", phone=" + phone + ", site=" + site + ", faxes=" + faxes + "]";
	}

}