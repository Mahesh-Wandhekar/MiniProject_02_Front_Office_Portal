package com.nt.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(String to,String subject,String body) {
		
		 boolean issent=false;
		try {
			MimeMessage mime=javaMailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper( mime,true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);
			javaMailSender.send(mime);
			issent=true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return issent;
	}
	
	public boolean sendMailFogotPws(String to,String subject,String body) {
		
		 boolean issent=false;
		try {
			MimeMessage mime=javaMailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper( mime,true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);
			javaMailSender.send(mime);
			issent=true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return issent;
	}
	 
	public EmailUtils() {
		// TODO Auto-generated constructor stub
	}

}
