package com.gotoLinks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GotoLinksController {

	@RequestMapping("/login")
	public String showLogin(ModelMap model) {
		
		model.put("message", "Dhruv");
		return "login";
	}
	
}
