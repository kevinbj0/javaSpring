package com.sh.scroll;

import java.util.List;

public interface slideRespositoryI {
	public int totalCnt();
	public List<SlideDTO> getSlide(int curpage, int pageSize);
}
