package com.acorn.prac;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRespository {
	
	@Autowired
	private SqlSession session; //SqlSession은 MyBatis 기능
	
    private static String namespace = "com.acorn.MemberMapper."; 
    //mapper의 namespace
    
    public List<Member> selectAll(){
    	//selectList : 데이터베이스에서 데이터를 검색하고 list로 반환하는 역할
    	return session.selectList(namespace + "selectAll");
    }
    
    public Member select(String id) {
    	return session.selectOne(namespace + "selectOne", id);
    }
}
