package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.EnquiryDetails;

public interface EnquiryDetailsRepo extends JpaRepository<EnquiryDetails, Integer>{

	public EnquiryDetails findByEnquiryId(Integer enquiryId);
}
