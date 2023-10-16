package com.acron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.inter.GoogleApi;


@Service //컴포넌트의 역할
public class MyService {
	
	@Autowired
	MyRepository repository;
	
	@Autowired
	GoogleApi api;
        
	//Member m
	public void userRegister( String id, String name ) {
		// 
		//회원가입
		//위도, 경도String latitude , String longitude
		double[] result = api.위도경도구하기();
		repository.insertMember(id, name, String.valueOf(result[0]), String.valueOf(result[1]));
		
	}
}
