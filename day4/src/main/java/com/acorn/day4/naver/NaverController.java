package com.acorn.day4.naver;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaverController {
	@Autowired
	ApiExamSearchBlog api;
	
	@Autowired
	ApiExamSearchBlog2 api2;
	
	@ResponseBody
	@GetMapping( value="/naver"  ,produces = "application/json;charset=UTF-8")
	public String naverAPi() {
		String result = api.getNaverAPI();
		return result;
	}
	

	
	@ResponseBody
	@GetMapping( value="/naverList"  )
	public ArrayList<ItemDTO> naverAPI2(Model model){
		String result  =api2.getNaverAPI();
		ArrayList<ItemDTO> list  =api2.fromJSONItems(result);
		model.addAttribute("list", list);
		return list;
	}
	
	//c:foreach 사용
	@GetMapping( value="/naverTest"  )
	public String naverTest(Model model){
		String result  =api2.getNaverAPI();
		ArrayList<ItemDTO> list  =api2.fromJSONItems(result);
		model.addAttribute("list", list);
		return "naverTest1";
	}
	
	//ajax 사용
	@ResponseBody
	@GetMapping( value="/naverAjax")
	public ArrayList<ItemDTO> naverTest2(){
		String result  =api2.getNaverAPI();
		ArrayList<ItemDTO> list  =api2.fromJSONItems(result);
		return list;
	}
	
	@RequestMapping("naverTest2")
	public void mainTest2() {
	}
}
