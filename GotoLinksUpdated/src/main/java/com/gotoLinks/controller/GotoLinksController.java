package com.gotoLinks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoLinks.entity.UserBean;
import com.gotoLinks.service.GotoLinksService;

@Controller
public class GotoLinksController {

	@Autowired
	GotoLinksService linkService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String firstName, @RequestParam String lastName , @RequestParam String email, 
			@RequestParam String password, ModelMap model) {
		
		UserBean userBean = new UserBean(firstName, lastName, email, password);
		linkService.saveUser(userBean);
		
		model.put("message", "Registration successful.");
		return "login";
	}
	
}
