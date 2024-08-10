package com.nt.Binding;

import org.springframework.stereotype.Component;

@Component
public class FogotBinding {

	private  String email;

	public String getEmail() {
		return email;
	}

	public FogotBinding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public FogotBinding(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "FogotBinding [email=" + email + "]";
	}
	
	
}
