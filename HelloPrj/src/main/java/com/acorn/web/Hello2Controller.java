package com.acorn.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello2Controller {


	@ResponseBody
	@GetMapping("/data1")
	public String method() {
		return "hi";
	}
	@ResponseBody
	@GetMapping("/data2")
	public User method2() {
		User user = new User("test02","1234");
		return user;
	}
	@ResponseBody
	@GetMapping("/data3")
	public ArrayList<User> method3(){
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("test01","0000"));
		list.add(new User("test02","1234"));
		list.add(new User("test03","9999"));
		
		return list;
	}
	
	
}
