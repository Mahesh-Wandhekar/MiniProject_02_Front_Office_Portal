package com.nt.Binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

public class LoginBinding {
	
	private String email;
	private String password;

	
	
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



	public LoginBinding(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return "LoginBinding [email=" + email + ", password=" + password + "]";
	}



	public LoginBinding() {
		// TODO Auto-generated constructor stub
	}

}
