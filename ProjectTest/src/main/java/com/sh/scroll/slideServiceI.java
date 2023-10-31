package com.sh.scroll;

import java.util.List;

public interface slideServiceI {
	public int  getTotalCnt();
	public List<SlideDTO> getListSlide(int curpage, int pageSize);
}
