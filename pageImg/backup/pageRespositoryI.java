package com.carrot.page;

import java.util.List;

public interface pageRespositoryI {
	
	public int totalCnt();
	public List<BoardDTO> getPage(int page, int pageSize);

}
