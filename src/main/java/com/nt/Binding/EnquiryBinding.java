package com.nt.Binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class EnquiryBinding {
	
	private String sname;
    private String contactNo; 
    private String classMode;
    private String course;
    private String statusMode;
	
	

	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getContactNo() {
		return contactNo;
	}



	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public String getClassMode() {
		return classMode;
	}



	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public String getStatusMode() {
		return statusMode;
	}



	public void setStatusMode(String statusMode) {
		this.statusMode = statusMode;
	}


	

	public EnquiryBinding(String sname, String contactNo, String classMode, String course, String statusMode) {
		super();
		this.sname = sname;
		this.contactNo = contactNo;
		this.classMode = classMode;
		this.course = course;
		this.statusMode = statusMode;
	}



	@Override
	public String toString() {
		return "EnquiryBinding [sname=" + sname + ", contactNo=" + contactNo + ", classMode=" + classMode + ", course="
				+ course + ", statusMode=" + statusMode + "]";
	}



	public EnquiryBinding() {
		// TODO Auto-generated constructor stub
	}

}
