package com.carrot.page;

import java.util.List;

public interface pageServiceI {
	public int  getTotalCnt();
	public List<BoardDTO> getListPage(int curpage, int pageSize);
	
	public List<BoardDTO> getListSlide(int curpage, int pageSize);
}
