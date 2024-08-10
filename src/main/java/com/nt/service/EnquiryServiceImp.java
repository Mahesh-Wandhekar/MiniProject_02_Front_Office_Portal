package com.nt.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Binding.DashbordDataBinding;
import com.nt.Binding.EnquiryBinding;
import com.nt.Binding.EnquirySearchCriteri;
import com.nt.Entity.CourseDetails;
import com.nt.Entity.EnquiryDetails;
import com.nt.Entity.EnquiryStatus;
import com.nt.Entity.UserDetails;
import com.nt.Repository.CourseRepo;
import com.nt.Repository.EnquiryDetailsRepo;
import com.nt.Repository.EnquiryStatusRepo;
import com.nt.Repository.UserDetailsRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryServiceImp implements EnquiryService {

	@Autowired
	private HttpSession session;

	@Autowired
	private EnquiryDetailsRepo enqdetailsRepo;

	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private EnquiryStatusRepo enquiryStatusRepo;

	@Override
	public List<String> getCourse() {
		List<CourseDetails> findAll = courseRepo.findAll();
		List<String> names = new ArrayList<String>();
		for (CourseDetails courseDetails : findAll) {
			names.add(courseDetails.getCourseName());
		}
		return names;
	}

	@Override
	public List<String> getEnquiryStatus() {
		List<EnquiryStatus> findAll = enquiryStatusRepo.findAll();
		List<String> status = new ArrayList<String>();
		for (EnquiryStatus details : findAll) {
			status.add(details.getEnquiryStatus());
		}
		return status;
	}

	@Override
	public DashbordDataBinding dashbordDataBinding(Integer userId) {
	    DashbordDataBinding resBinding = new DashbordDataBinding();
	    
	    // Fetch user details from repository
	    Optional<UserDetails> findby = userDetailsRepo.findById(userId);
	    
	    // Handle case where user is not found
	    if (findby.isPresent()) {
	        UserDetails user = findby.get();
	        List<EnquiryDetails> enquiry = user.getEnquiryDetails();

	        // Initialize counts
	        Integer totalcnt = enquiry.size();
	        Integer enrolledCount = 0;
	        Integer lostCount = 0;

	        // Optimize counting by single pass through the list
	        for (EnquiryDetails e : enquiry) {
	            if ("Enrolled".equals(e.getStatusMode())) {
	                enrolledCount++;
	            } else if ("Lost".equals(e.getStatusMode())) {
	                lostCount++;
	            }
	        }

	        // Set counts in result binding
	        resBinding.setTotalCnt(totalcnt);
	        resBinding.setEnrolledCnt(enrolledCount);
	        resBinding.setLostCnt(lostCount);
	    } else {
	        // Set default values if user is not found
	        resBinding.setTotalCnt(0);
	        resBinding.setEnrolledCnt(0);
	        resBinding.setLostCnt(0);
	    }
	    
	    return resBinding;
	}

	@Override
	public boolean EnquiryDetails(EnquiryBinding binding) {
		EnquiryDetails enquiryDetails = new EnquiryDetails();
		BeanUtils.copyProperties(binding, enquiryDetails);
		Integer userId = (Integer) session.getAttribute("userId");
		UserDetails userenity = userDetailsRepo.findById(userId).get();
		enquiryDetails.setUserDetails(userenity);		
		enqdetailsRepo.save(enquiryDetails);
		return true;
	}

	

	@Override
	public List<com.nt.Entity.EnquiryDetails> getEnquires() {
		Integer userId=(Integer)session.getAttribute("userId");
		Optional<UserDetails> userDtls =userDetailsRepo.findById(userId);
		if(userDtls.isPresent()) {
			UserDetails userDetails=userDtls.get();
			List<EnquiryDetails> allEnquires= userDetails.getEnquiryDetails();
			return allEnquires;
		}	
		return null;
	}
	
	
	@Override
	public List<com.nt.Entity.EnquiryDetails> getFilterdEnquiry(EnquirySearchCriteri criteri, Integer userId) {
		Optional<UserDetails> user=userDetailsRepo.findById(userId);
		if(user.isPresent()) {
			UserDetails userDetails=user.get();
			List<EnquiryDetails> enquires=userDetails.getEnquiryDetails();
			
			
			if(null != criteri.getCname() && !"".equals(criteri.getCname())) {
				enquires =	enquires.stream()
						.filter(e->e.getCourse().equals(criteri.getCname()))
						.collect(Collectors.toList());
				
			}
			if(null != criteri.getEnquiryStatus() && !"".equals(criteri.getEnquiryStatus())) {
				enquires =	enquires.stream()
						.filter(e->e.getStatusMode().equals(criteri.getEnquiryStatus()))
						.collect(Collectors.toList());
				
			}
			if(null != criteri.getClassMode() && !"".equals(criteri.getClassMode())) {
				enquires =	enquires.stream()
						.filter(e->e.getClassMode().equals(criteri.getClassMode()))
						.collect(Collectors.toList());
				
			}
			return enquires ;
		}
		return null;
	}
	
	@Override
	public EnquiryDetails editEnquiry( Integer enquiryId) {
		EnquiryDetails enquiry = enqdetailsRepo.findByEnquiryId(enquiryId);
		return enquiry;
	}
	
	@Override
	public boolean saveOrupdate(EnquiryDetails details,Integer userId) {	
		
		UserDetails userenity = userDetailsRepo.findById(userId).get();
		details.setUserDetails(userenity);		
		enqdetailsRepo.save(details);
		return true;	
		
		
	}
}
