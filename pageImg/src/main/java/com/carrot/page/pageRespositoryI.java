package com.carrot.page;

import java.util.List;

public interface pageRespositoryI {
	
	public int totalCnt();
	public List<BoardDTO> Page(int page, int pageSize);

}
