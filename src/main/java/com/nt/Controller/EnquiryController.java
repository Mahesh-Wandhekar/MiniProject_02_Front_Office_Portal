package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.Binding.DashbordDataBinding;
import com.nt.Binding.EnquiryBinding;
import com.nt.Binding.EnquirySearchCriteri;
import com.nt.Entity.EnquiryDetails;
import com.nt.service.EnquiryService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private HttpSession session;

	@Autowired
	private EnquiryService enquiryService;

	@GetMapping("logout")
	public String logout(Model model) {
		session.invalidate();
		return "index";
	}

	@GetMapping("dashboard")
	public String dashboard(Model model) {
		Integer user = (Integer) session.getAttribute("userId");
		DashbordDataBinding dashboard = enquiryService.dashbordDataBinding(user);
		model.addAttribute("dashboardData", dashboard);
		return "dashboard";
	}

	@GetMapping("enquiry")
	public String enquiryPage(Model model) {
		EnquiryBinding enquiry = new EnquiryBinding();
		List<String> courses = enquiryService.getCourse();
		List<String> status = enquiryService.getEnquiryStatus();
		model.addAttribute("coursesName", courses);
		model.addAttribute("statusName", status);
		model.addAttribute("enquiry", enquiry);
		return "add-enquiry";
	}

	@PostMapping("enquiry")
	public String addEnquiry(@ModelAttribute("enquiry") EnquiryBinding bind, Model model) {
		System.out.println(bind);
		boolean status = enquiryService.EnquiryDetails(bind);
		if (status) {
			model.addAttribute("sucmsg", "Enquiry Added Successfully..!");
		} else {
			model.addAttribute("errmsg", "Enquiry Added Failed..!");
			
		}
		return "add-enquiry";
	}

	public EnquiryController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("enquires")
	public String viewEnquires(Model model) {

		init(model);

		List<EnquiryDetails> enquiries = enquiryService.getEnquires(); // Changed to 'enquiries' for consistency
		model.addAttribute("enquiries", enquiries); // Updated to match the template
		return "view-enquiries";
	}

	public void init(Model model) {
		model.addAttribute("courses", enquiryService.getCourse()); // Corrected attribute name
		model.addAttribute("statusList", enquiryService.getEnquiryStatus()); // Consistent naming
	}

	@GetMapping("search")
	public String getFilterdEnquiry(@RequestParam(value = "cname", required = false) String cname,
			@RequestParam(value = "enquiryStatus", required = false) String enquiryStatus,
			@RequestParam(value = "classMode", required = false) String classMode, Model model) {


		EnquirySearchCriteri criteri = new EnquirySearchCriteri();
		criteri.setCname(cname);
		criteri.setEnquiryStatus(enquiryStatus);
		criteri.setClassMode(classMode);
		
		
		Integer userId = (Integer) session.getAttribute("userId");
		List<EnquiryDetails> enquires = enquiryService.getFilterdEnquiry(criteri, userId);

		model.addAttribute("enquiry", enquires);

		return "filter-Enquiry";

	}

	@GetMapping("editEnquiry")
	public String editEnquiry(@RequestParam("enquiryId") Integer enquiryId, Model model) {

		EnquiryDetails enquiryDetails = enquiryService.editEnquiry(enquiryId);
		List<String> courses = enquiryService.getCourse();
		List<String> status = enquiryService.getEnquiryStatus();
		model.addAttribute("enquiryId", enquiryId);
		model.addAttribute("coursesName", courses);
		model.addAttribute("statusName", status);
		model.addAttribute("enquiry", enquiryDetails);

		return "editEnquiry";
	}
	
	@PostMapping("edit")
	public String edit( @ModelAttribute("enquiry") EnquiryDetails details ,Model model ) {	
		
		Integer userId=(Integer)session.getAttribute("userId");
	boolean status=	enquiryService.saveOrupdate(details,userId);
		if(status) {
			model.addAttribute("sucmsg","Enquiry Updated SuccessFully...!");
		}else {		
			model.addAttribute("errmsg","Enquiry Updated ...!");
		}
		return "editEnquiry";
	}


}
