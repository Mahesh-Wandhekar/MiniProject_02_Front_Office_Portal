package com.nt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.Entity.CourseDetails;
import com.nt.Entity.EnquiryStatus;
import com.nt.Repository.CourseRepo;
import com.nt.Repository.EnquiryStatusRepo;

@SpringBootApplication
public class MiniProject02FrontOfficePortalForStudentEnquiryApplication {

	
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(MiniProject02FrontOfficePortalForStudentEnquiryApplication.class, args);
		
		CourseRepo courseRepo=context.getBean(CourseRepo.class);
		EnquiryStatusRepo enquiryStatusRepo=context.getBean(EnquiryStatusRepo.class);
		
		
		
		CourseDetails c1=new CourseDetails();
		c1.setCourseName("Java Fullstack");
		CourseDetails c2=new CourseDetails();
		c1.setCourseName("Python Fullstack");
		CourseDetails c3=new CourseDetails();
		c1.setCourseName("AWs");
		
		EnquiryStatus e1=new EnquiryStatus();
		e1.setEnquiryStatus("New");
		EnquiryStatus e2=new EnquiryStatus();
		e1.setEnquiryStatus("Enrolled");
		EnquiryStatus e3=new EnquiryStatus();
		e1.setEnquiryStatus("Lost");
		
		
		
		
	}

}
