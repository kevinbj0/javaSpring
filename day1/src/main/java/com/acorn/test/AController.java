package com.acorn.test;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AController{

	@GetMapping("/test4")
	public void test1() {
		
	}


}
