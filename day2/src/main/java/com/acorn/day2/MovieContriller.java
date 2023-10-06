package com.acorn.day2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieContriller {
	@Autowired
	MovieService service;
	
	@RequestMapping("/mov")
	public String pMovie(Model model){
		ArrayList<Movie> list = new ArrayList<Movie>();
		list = service.pMovie();
		model.addAttribute("list", list);
		
		return "movie";
	}
}
