package com.hxw.springboot.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Bill implements Serializable {
	private Integer bId;

	private Integer sId;

	private String bName;

	private String bDescribe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bTime;

	private String payment;

	private Integer bQuote;

	private String unit;

	private String count;

	private String supName;// 供应商名称

	@Override
	public String toString() {
		return "Bill [bId=" + bId + ", sId=" + sId + ", bName=" + bName + ", bDescribe=" + bDescribe + ", bTime="
				+ bTime + ", payment=" + payment + ", bQuote=" + bQuote + ", unit=" + unit + ", count=" + count
				+ ", supName=" + supName + "]";
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName == null ? null : bName.trim();
	}

	public String getbDescribe() {
		return bDescribe;
	}

	public void setbDescribe(String bDescribe) {
		this.bDescribe = bDescribe == null ? null : bDescribe.trim();
	}

	public Date getbTime() {
		return bTime;
	}

	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment == null ? null : payment.trim();
	}

	public Integer getbQuote() {
		return bQuote;
	}

	public void setbQuote(Integer bQuote) {
		this.bQuote = bQuote;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count == null ? null : count.trim();
	}
}