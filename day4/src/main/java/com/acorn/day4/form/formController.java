package com.acorn.day4.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formController {
	
	@GetMapping("/formRead")
	public String form() {
		return "formView";
	}
	
	//Get으로 받아오는 방식
	@GetMapping("/formRegisterGet")
	public void formget(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
	}
	
	//Post로 받아오는 방식
	@PostMapping("/formRegisterPost")
	public void formpost(HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		//BufferedReader: 1줄씩 읽어오기 위해 필요
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = "";
		StringBuilder resultData = new StringBuilder();
		
		while((line = reader.readLine())!=null) {
			resultData.append(line);
		}
		
		System.out.println(resultData);
	}
}
