package com.acorn.day2.실습;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	@Autowired
	MovieDAO dao;
	
	@RequestMapping("/movTest")
	public String pmovie(Model model) {
		ArrayList<Movie> list = dao.MoviePrint();
		model.addAttribute("testMovie",list);
	
		for(Movie item : list) {
			System.out.println(item.name);
		}
		
		return "movie2";
	}
}
