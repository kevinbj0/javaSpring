package com.acorn.cookie;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) // 매핑은 /login/login
	public String loginForm(String id, String pwd, boolean rememberId, HttpServletResponse response, HttpServletRequest request) {
		
		//로그인 성공했을 때
		if(loginCheck(id,pwd)) {
			//세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("sessionId",id ); 
			
			//성공했을 때 아이디 기억
			if(rememberId) {
				//저장
				Cookie cookie = new Cookie("id",id);
				response.addCookie(cookie);
			}else {
				//삭제
				Cookie cookie = new Cookie("id",id); //value는 중요하지않음
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "main";
		}else {//로그인 실패했을 때
			//

			String msg = URLEncoder.encode("id or pw 틀림");
			return "redirect:/login/login?msg="+msg; //response.sendRedirect("/login/login");와 동일
		}
	}
	@RequestMapping("/logOut")
	public String logOUt(HttpServletRequest request	) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	public boolean loginCheck(String id, String pwd) {
		
		//데이터베이스 체크해야하는 부분
		if(id.equals("acorn") && pwd.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
