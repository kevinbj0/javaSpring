package com.acorn.day2;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class MovieService {
	
	ArrayList<Movie> list = new ArrayList<Movie>();

	public ArrayList<Movie> pMovie(){
		list.add(new Movie("왕이될상",8000));
		list.add(new Movie("겨울왕국",10000));
		list.add(new Movie("쥬토피아",3000));
		list.add(new Movie("아이언맨",5000));
		
		return list;
	}
}
