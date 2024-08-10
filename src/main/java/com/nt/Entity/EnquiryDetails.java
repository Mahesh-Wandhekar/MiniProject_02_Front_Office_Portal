package com.nt.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enquiry_Details")

public class EnquiryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;

    private String sname;
    private String contactNo; 
    private String classMode;
    private String course;
    private String statusMode;
    
    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDate creationDate;
    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", insertable = false)
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserDetails userDetails;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public EnquiryDetails(Integer enquiryId, String sname, String contactNo, String classMode, String course,
			String statusMode, LocalDate creationDate, LocalDate updateDate, UserDetails userDetails) {
		super();
		this.enquiryId = enquiryId;
		this.sname = sname;
		this.contactNo = contactNo;
		this.classMode = classMode;
		this.course = course;
		this.statusMode = statusMode;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.userDetails = userDetails;
	}

	public EnquiryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EnquiryDetails [enquiryId=" + enquiryId + ", sname=" + sname + ", contactNo=" + contactNo
				+ ", classMode=" + classMode + ", course=" + course + ", statusMode=" + statusMode + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", userDetails=" + userDetails + "]";
	}

	
    
}
