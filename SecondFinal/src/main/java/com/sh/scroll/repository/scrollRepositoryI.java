package com.sh.scroll.repository;

import java.util.List;

import com.sh.scroll.domain.ScrollDTO;

public interface scrollRepositoryI {
	public int totalCnt();
	
	//인기순, 최신순
	public List<ScrollDTO> getScroll(int curpage, int pageSize, String mode);
	
	//검색
	public List<ScrollDTO> getSearchList(String searchTerm);
	
	//관심상품
	public List<ScrollDTO> getLikeList(String userId);
}
