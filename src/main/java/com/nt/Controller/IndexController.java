package com.nt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	public IndexController() {
		// TODO Auto-generated constructor stub
	}

}
