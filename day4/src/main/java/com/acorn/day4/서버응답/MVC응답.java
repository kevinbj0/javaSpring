package com.acorn.day4.서버응답;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//view + data 가공된 형태로 -> MVC 

@Controller
public class MVC응답 {
	
	@GetMapping("/mvc1")
	public String mvc1(Model model) {
		model.addAttribute("message1","mvc1");
		return "뷰이름"; 
		//return으로 뷰가 응답
	}
	
	
	@GetMapping("/mvc2") //mvc2를 view로 인식
	public void mvc2(Model model) {
		model.addAttribute("message2","mvc2");
	}
	
	@GetMapping("/mvc3")
	public ModelAndView mvc3(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("뷰이름2");
		mv.addObject("message3","mvc3");
		
		return mv;
	}
	
}
