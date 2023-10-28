package com.carrot.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class pageController {
	
	@Autowired
	pageServiceI service;

	@GetMapping("/listPageJstl")
	public String logintest() {
		return "listPageJstl";
	}
	
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

	
	@GetMapping("/slidelist")
	public String slidePage(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt();
		System.out.println(toRecords + ", "+ p);
		int pageSize = 5;
		int grpSize = 2;
		PageHandler handler = new PageHandler(currentPage, toRecords, pageSize, grpSize);
		List<BoardDTO> list = service.getListSlide(currentPage, pageSize);
		
		model.addAttribute("handler",handler);
		model.addAttribute("list",list);
		
		return "slidePage";
	}
	
	
	@GetMapping("/slidelist2")
	public String slideHome2() {
		return "slidePage2";
	}
	@GetMapping("/slidelist2")
	public String slidePage2(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt();
		System.out.println(toRecords + ", "+ p);
		int pageSize = 5;
		int grpSize = 2;
		PageHandler handler = new PageHandler(currentPage, toRecords, pageSize, grpSize);
		List<BoardDTO> list = service.getListSlide(currentPage, pageSize);
		
		model.addAttribute("handler",handler);
		model.addAttribute("list",list);
		
		return "slidePage2";
	}

	
}
