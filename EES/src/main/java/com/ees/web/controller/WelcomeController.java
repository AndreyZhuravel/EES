package com.ees.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {

	//When application start - method return word "welcome" and call SpringWebConfig and create view welcome.jsp;
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "welcome";
	} //word "welcome"
}
