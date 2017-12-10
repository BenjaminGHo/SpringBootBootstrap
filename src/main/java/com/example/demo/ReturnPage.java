package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnPage {

	@RequestMapping("/ReturnPage")
	String finn(String name, Model model) {
		 model.addAttribute("name", "Giggles");		 
		return "index";
	}
	
}
