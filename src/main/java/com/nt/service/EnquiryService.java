package com.nt.service;



import java.util.List;

import com.nt.Binding.DashbordDataBinding;
import com.nt.Binding.EnquiryBinding;
import com.nt.Binding.EnquirySearchCriteri;
import com.nt.Entity.EnquiryDetails;

public interface EnquiryService {

	public List<String> getCourse();
	public List<String> getEnquiryStatus();
	public DashbordDataBinding dashbordDataBinding(Integer userId);
	public boolean EnquiryDetails(EnquiryBinding binding);
	
	public  List<EnquiryDetails> getEnquires();
	
	public List<EnquiryDetails> getFilterdEnquiry(EnquirySearchCriteri criteri,Integer userId);
	
	public EnquiryDetails editEnquiry(Integer enquiryId);
	public boolean saveOrupdate( EnquiryDetails details,Integer userId); 
	
}
