package com.sh.login.repository;

import java.util.List;

import com.sh.login.domain.LoginDTO;

public interface LoginRepositoryI {
	public boolean checklogin(LoginDTO loginDTO);

	List<Object> selectAll(LoginDTO loginDTO);

	public int update(LoginDTO loginDTO);

	public int delete(LoginDTO loginDTO);
	
	public String selectHeat(String sell_code);


	int updateHeat(String user_heat, String user_code);

}
