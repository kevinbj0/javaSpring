package com.sh.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.login.domain.LoginDTO;
import com.sh.login.repository.LoginRepositoryI;

@Service
public class LoginService implements LoginServiceI {

	@Autowired
	private LoginRepositoryI userRepository;

	@Override
	public boolean checkLogin(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.checklogin(loginDTO);
	}

	@Override
	public List<Object> selectAll(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.selectAll(loginDTO);
	}

	@Override
	public int updateUser(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.update(loginDTO);
	}

	@Override
	public int deleteUser(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.delete(loginDTO);
		
		
	}
	
	@Override
	public String selectHeat(String sell_code) {
		return userRepository.selectHeat(sell_code);
	}

	@Override
	public int updateHeat(String user_heat,String user_code) {
		System.out.println("서비스에서 보기"+user_heat+"@@@@@@@@@"+user_code);
		return userRepository.updateHeat(user_heat,user_code);
	}
	
	

	
	
}