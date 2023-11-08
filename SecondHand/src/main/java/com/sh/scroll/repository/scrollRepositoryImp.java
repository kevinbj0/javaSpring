package com.sh.scroll.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.scroll.domain.ScrollDTO;

@Repository
public class scrollRepositoryImp implements scrollRepositoryI{
	@Autowired
	private SqlSession session;
	private static String namespace = "com.sh.scrollMapper";
	
	
	@Override
	public int totalCnt() {
		return session.selectOne( namespace + ".getTotalCnt");
	}
	
	//인기순, 최신순
	@Override
	public List<ScrollDTO> getScroll(int curpage, int pageSize, String mode) {
		int itemNum = pageSize*curpage;
		return session.selectList( namespace + mode, itemNum);
	}

	//검색
	public List<ScrollDTO> getSearchList(String searchTerm) {
	    return session.selectList(namespace + ".getSearchList", searchTerm);
	}
	
	//관심상품
	@Override
	public List<ScrollDTO> getLikeList(String userId) {
		return session.selectList(namespace + ".getLikeList", userId);
	}
	
}
