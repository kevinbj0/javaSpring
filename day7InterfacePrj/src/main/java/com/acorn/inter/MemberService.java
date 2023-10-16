package com.acorn.inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	GoogleApi api;
	
	
	public void memberRegister() {
		double[] result = api.위도경도구하기();
		
		System.out.println(result[0]);
	}
}
