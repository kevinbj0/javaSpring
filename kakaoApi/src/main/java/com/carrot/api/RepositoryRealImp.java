package com.carrot.api;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
@Repository
public class RepositoryRealImp  implements UserRespositoryI {
	  @Autowired
	    private SqlSession session;
	    private static String namespace = "com.carrot.UserMapper.";
	    
	@Override
	public int insert(UserDTO user) {
		return session.insert(namespace+"insert", user);
	}
}
