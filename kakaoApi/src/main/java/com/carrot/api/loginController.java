package com.carrot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
	 	@GetMapping("/logintest")
	    public String logintest() {
	        return "logintest"; 
	    }
}
