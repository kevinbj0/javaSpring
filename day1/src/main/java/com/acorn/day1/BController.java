package com.acorn.day1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//매서드 단위로 매핑
@Controller
public class BController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() { //=>view이름을 의미
		return "viewName";
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public void test2() {
		//void 일때는 매핑정보를 view이름으로 인식함
	}
	
	@GetMapping("/test3")
	public void test3() {
		//test3 view
	}
}
