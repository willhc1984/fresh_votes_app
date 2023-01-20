package com.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashBoardController {
	
	@GetMapping(value = "/")
	public String rootView() {
		return "index";
	}	
	
	@GetMapping(value = "/dashboard")
	public String dashboard() {
		return "dashboard";
	}	

}