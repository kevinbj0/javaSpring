package com.sh.login.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sh.login.domain.LoginDTO;

@Repository
public class LoginRepositoryImp implements LoginRepositoryI {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.sh.login.LoginMapper.";

	@Override
	public boolean checklogin(LoginDTO loginDTO) {

		LoginDTO user = session.selectOne(namespace + "checklogin", loginDTO);

		// System.out.println("db user=>" + user);

		// 사용자를 찾지 못한 경우
		if (user == null) {
			return false;
		}

		// 입력한 아이디와 비밀번호가 데이터베이스의 값과 일치하는지 확인
		if (user.getUser_id().equals(loginDTO.getUser_id()) && user.getUser_pw().equals(loginDTO.getUser_pw())) {
			return true; // 로그인 성공
		} else {
			return false; // 로그인 실패
		}
	}

	@Override
	public List<Object> selectAll(LoginDTO loginDTO) {

		List<Object> user1 = session.selectList(namespace + "selectAllU", loginDTO);
		return user1;
	}

	@Override
	public int update(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return session.update(namespace + "updateUser", loginDTO);
	}
	@Override
	   public int delete(LoginDTO loginDTO) {
	      // TODO Auto-generated method stu	b
	      return session.delete(namespace + "deleteUser", loginDTO);
	   }
	
	@Override
	public String selectHeat(String sell_code) {
		String heat = session.selectOne(namespace + "selectHeat", sell_code);
		return heat;

	}
	
	@Override
	public int updateHeat(String user_heat,String user_code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_heat", user_heat);
		map.put("user_code", user_code);
		
		System.out.println(user_heat);
		System.out.println(user_code);
		return session.update( namespace + "updateHeat",map);
	}
	



}
