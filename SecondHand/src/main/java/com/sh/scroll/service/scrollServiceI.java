package com.sh.scroll.service;

import java.util.List;

import com.sh.scroll.domain.ScrollDTO;

public interface scrollServiceI {
	public int  getTotalCnt();
	//인기순, 최신순
	public List<ScrollDTO> getListScroll(int curpage, int pageSize, String mode);
	
	//검색
	List<ScrollDTO> getSearchList(String searchTerm);
	
	//관심상품
	public List<ScrollDTO> getLikeList(String userId);
	
}
