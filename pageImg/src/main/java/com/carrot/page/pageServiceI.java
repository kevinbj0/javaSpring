package com.carrot.page;

import java.util.List;

public interface pageServiceI {
	public int  getTotalCnt();
	public List<BoardDTO> getListPage(int page, int pageSize);
}
