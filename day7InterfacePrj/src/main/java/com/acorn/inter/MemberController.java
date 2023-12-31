package com.acorn.inter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {
	
	@Autowired
	MemberServiceI service;
	

	@GetMapping("/memberT")
	public String  register() {		
		return "memberT";
	}
	
	
	@PostMapping("/memberT")
	
	public String  register( Member member) {
		service.registerMember(member); 
		return "home";
	}
	
	@PostMapping("/memberD")
	public String  register(String id) {
		service.deleteMember(id); 
		return "home";
	}
}
