package com.acorn.ex;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionCatcher2 {
	
	//여기서 다 받음
	@ExceptionHandler(SQLException.class)
	public String catcher1(SQLException ex, Model model) {
		model.addAttribute("ex",ex);
		return "err2";
	}
	
	@RequestMapping("/db2")
	public String method1() throws SQLException { //예외를 여기서 던짐
		throw new SQLException();
	}
	
	@RequestMapping("/db3")
	public String method2() throws SQLException { //예외를 여기서 던짐
		throw new SQLException();
	}
}
