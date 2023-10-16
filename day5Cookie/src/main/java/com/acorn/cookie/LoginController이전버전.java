package com.acorn.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginTest")
public class LoginController이전버전 {
	
	@RequestMapping("/loginTest") // 매핑은 /login/login
	public String loginForm(String id, String pwd, boolean rememberId, HttpServletResponse response) {
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(rememberId);
		
		//아이디기억 여부판단
		//1.기억(쿠키저장)
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}
		//2.체크x(쿠키삭제)
		else {
			//remove가 없음
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie); //유효기간을 0으로 해서 다시 보냄
		}
		
		return "loginForm";
	}
	
	
}
