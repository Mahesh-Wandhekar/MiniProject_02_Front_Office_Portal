package com.nt.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User_Details")

public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    private String name;
    private String email;
    private String phone;
    private String password;
    private String status;
    
    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnquiryDetails> enquiryDetails;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<EnquiryDetails> getEnquiryDetails() {
		return enquiryDetails;
	}

	public void setEnquiryDetails(List<EnquiryDetails> enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}

	public UserDetails(Integer userId, String name, String email, String phone, String password, String status,
			List<EnquiryDetails> enquiryDetails) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.enquiryDetails = enquiryDetails;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", status=" + status + ", enquiryDetails=" + enquiryDetails + "]";
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
