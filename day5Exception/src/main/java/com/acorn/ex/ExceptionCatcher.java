package com.acorn.ex;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionCatcher {
	
	@RequestMapping("/db")
	public String method1() {
		String view = "view1";
		try {
			throw new SQLException();
		}catch(SQLException ex) {
			//오류가 발생했을 때 error 페이지가 보일 수 있도록
			view = "err";
		}
		
		return view;
	}
}
