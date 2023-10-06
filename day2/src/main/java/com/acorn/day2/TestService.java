package com.acorn.day2;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class TestService {

	public ArrayList<String> getDan(int dan){
		
		ArrayList<String> danList = new ArrayList<>();
		
		for(int i=1; i<=9; i++) {
			danList.add(dan+"x"+i+"="+dan*i);
		}
		
		
		return danList;
	}
}
