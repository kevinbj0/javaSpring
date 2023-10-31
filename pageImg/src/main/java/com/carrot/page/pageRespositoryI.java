package com.carrot.page;

import java.util.List;

public interface pageRespositoryI {
	public int totalCnt();
	public List<BoardDTO> getPage(int curpage, int pageSize);
	public List<BoardDTO> getSlide(int page, int pageSize);
}
