package com.nt.Utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtlis {

	public static String generatePassword() {
		String password = RandomStringUtils.random(12,
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		return password;

	}

	public PasswordUtlis() {
		// TODO Auto-generated constructor stub
	}

}
