package com.acorn.day1.di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class pController implements Controller{
	
	Program p;
	
	public void setP(Program p) {
		this.p = p;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = p.addP(5,3);
		System.out.println(result);
		return null;
	}

}
