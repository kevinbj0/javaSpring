package com.sh.scroll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.product.domain.ProductDTO;
import com.sh.product.service.ProductService;
import com.sh.scroll.domain.ScrollDTO;
import com.sh.scroll.domain.ScrollHandler;
import com.sh.scroll.service.scrollServiceI;

@Controller
public class scrollController {

	@Autowired
	scrollServiceI service;
	@Autowired
	private ProductService productservice;
	
	
	// 슬라이드 Ajax
	@GetMapping("/scrollHome")
	public String scrollHome(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		List<ProductDTO> products = productservice.getProductList();

		System.out.println(products);
		session.setAttribute("products", products);
		return "products/scrollPage";
	}

	@ResponseBody
	@GetMapping("/scroll")
	public Map<String, Object> scrollGet(String page, String mode) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		int toRecords = service.getTotalCnt();
	
		//스크롤 한번당 6개씩
		int pageSize = 9;

		ScrollHandler handler = new ScrollHandler(currentPage, toRecords, pageSize);
		
		//출력할 리스트 받아옴
		List<ScrollDTO> list = service.getListScroll(currentPage, pageSize, mode);

		// ajax에서 응답하는거라 model 사용 못함
		Map<String, Object> map = new HashMap<String, Object>();
		int totalPage = handler.getTotalPage();
		
		map.put("totalPage", totalPage);
		map.put("list", list);

		return map;
	}
	
	//관심 상품 목록
	@ResponseBody
	@PostMapping("/likeList")
	public List<ScrollDTO> likeList(String userId) {
		List<ScrollDTO> list = service.getLikeList(userId);
		return list;
	}
	

	@ResponseBody
	@GetMapping("/search")
	public List<ScrollDTO> searchGet(String searchTerm) {
		return service.getSearchList(searchTerm);
	}

}
