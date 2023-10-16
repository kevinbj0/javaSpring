package com.acorn.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitController {

	@RequestMapping("/count")
	public String cookie(HttpServletRequest request, HttpServletResponse response) {
		// 1.쿠키 읽기
		// 2.정보가 있는 경우 카운트 증가
		// 정보가 없는 경우(첫방문) -> 카운트 1
		// 3.쿠키 저장(사용자 pc에 저장 -> 클라이언트)
		Cookie[] cookies = request.getCookies();
		int count = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("쿠키이름 : " + cookie.getName()); // 쿠키의 키네임
				System.out.println("쿠키값 : " + cookie.getValue()); // 값이 무엇인가

				if (cookie.getName().equals("count")) {
					String count_ = cookie.getValue();
					count = Integer.parseInt(count_);
					break;
				}
			}
		}
		count++; // 10=>"10"(String.valueOf), "10"=>10
		Cookie cookie = new Cookie("count", String.valueOf(count));

		response.addCookie(cookie);

		return "visitHome";
	}
}
