package com.carrot.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class pageController {
	
	@Autowired
	pageServiceI service;
	
	//페이징
	@GetMapping("/listpage")
	public String logintest(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt();
		System.out.println(toRecords + ", "+ p);
		int pageSize = 3;
		int grpSize = 2;
		PageHandler handler = new PageHandler(currentPage, toRecords, pageSize, grpSize);
		List<BoardDTO> list = service.getListPage(currentPage, pageSize);
		
		model.addAttribute("handler",handler);
		model.addAttribute("list",list);
		
		return "listPage";
	}


	//슬라이드 + 페이징 테스트용
	@GetMapping("/slidelist")
	public String slidePage(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt();
		System.out.println(toRecords + ", "+ p);
		int pageSize = 3;
		int grpSize = 2;
		PageHandler handler = new PageHandler(currentPage, toRecords, pageSize, grpSize);
		List<BoardDTO> list = service.getListSlide(currentPage, pageSize);
		
		model.addAttribute("handler",handler);
		model.addAttribute("list",list);
		
		return "slidePage";
	}
	
	//슬라이드 Ajax
	@GetMapping("/slideHome")
	public String slideHome2() {
		return "slidePage2";
	}
	
	@ResponseBody
	@GetMapping("/slidelist2")
	public Map< String , Object> slidePage2(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt();
		System.out.println(toRecords + ", "+ p);
		int pageSize = 6;
		
		PageHandler2 handler = new PageHandler2(currentPage, toRecords, pageSize);
		List<BoardDTO> list = service.getListSlide(currentPage, pageSize);
		
		//ajax에서 응답하는거라 mode
		//model.addAttribute("handler",handler);
		//model.addAttribute("list",list);		
		Map< String , Object>  map = new HashMap<String, Object>();
		int totalPage = handler.totalPage;
		System.out.println("토탈" + totalPage);
		map.put("totalPage",totalPage);
		map.put("list",list);
		
		return map;
	}

	
}
