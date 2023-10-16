package com.acorn.ex;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class GlobelCatcher {
	
	//여기서 다 받음
	@ExceptionHandler(SQLException.class)
	public String catcher1(SQLException ex, Model model) {
		model.addAttribute("ex",ex);
		return "err2";
	}
	
	@ExceptionHandler(Exception.class)
	public void catcherAdd() {
		System.out.println("0보다 큰값이어야 합니다.");
	}
	
}
