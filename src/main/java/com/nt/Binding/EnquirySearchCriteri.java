package com.nt.Binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

public class EnquirySearchCriteri {
	
	public EnquirySearchCriteri() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String cname;
	private String enquiryStatus;
	private String classMode;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEnquiryStatus() {
		return enquiryStatus;
	}
	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}
	public String getClassMode() {
		return classMode;
	}
	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}
	public EnquirySearchCriteri(String cname, String enquiryStatus, String classMode) {
		super();
		this.cname = cname;
		this.enquiryStatus = enquiryStatus;
		this.classMode = classMode;
	}
	@Override
	public String toString() {
		return "EnquirySearchCriteri [cname=" + cname + ", enquiryStatus=" + enquiryStatus + ", classMode=" + classMode
				+ "]";
	}
	
	
	
	
	
	

}
