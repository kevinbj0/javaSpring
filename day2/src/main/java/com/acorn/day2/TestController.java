package com.acorn.day2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//매핑을 매서드 단위로
@Controller
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/gugudan")
	public String test1(Integer dan, Model model) {
		ArrayList<String> danList = service.getDan(dan);
		model.addAttribute("list",danList);
		System.out.println(danList);
		
		return "test";
	}
	
	@RequestMapping("/gugudan2")
	public String test2(@RequestParam(required = false,defaultValue = "3") Integer dan, Model model) {
		ArrayList<String> danList = service.getDan(dan);
		model.addAttribute("list",danList);
		System.out.println(danList);
		
		return "test";
	}
}
