package com.nt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Enquiry_Status")
public class EnquiryStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId;
	private String enquiryStatus;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	@Override
	public String toString() {
		return "EnquiryStatus [enquiryId=" + enquiryId + ", enquiryStatus=" + enquiryStatus + "]";
	}

	public EnquiryStatus(Integer enquiryId, String enquiryStatus) {
		super();
		this.enquiryId = enquiryId;
		this.enquiryStatus = enquiryStatus;
	}

	public EnquiryStatus() {
		// TODO Auto-generated constructor stub
	}

}
