package com.batis.slide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class slideController {
	
	@Autowired
	slideServiceI service;


	//슬라이드 홈
	@GetMapping("/slideHome")
	public String slideHome() {
		return "slidePage";
	}
	
	//슬라이드 Ajax
	@ResponseBody
	@GetMapping("/slidelist")
	public Map< String , Object> slidePage(String p, Model model) {
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		int toRecords = service.getTotalCnt(); //총 레코드의 수
		int pageSize = 6; //한 페이지당 출력할 아이템 수
		
		SlideHandler handler = new SlideHandler(currentPage, toRecords, pageSize);
		//페이지당 출력아이템수와 레코드의 수를 받아 총 페이지수를 저장
		List<SlideDTO> list = service.getListSlide(currentPage, pageSize);
		//현재 페이지와 사이즈를 받아 리스트를 반환
		
		//ajax에서 응답하는거라 model 말고 Map사용
		Map< String , Object>  map = new HashMap<String, Object>();
		int totalPage = handler.totalPage;
		System.out.println("총 갯수 = " + totalPage);
		System.out.println("출력 = " + list);
		
		//리스트와 페이지 정보를 ajax로 넘김
		map.put("totalPage",totalPage);
		map.put("list",list);
		
		return map;
	}

	
}