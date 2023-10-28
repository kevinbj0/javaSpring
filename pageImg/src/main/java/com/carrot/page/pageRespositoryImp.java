package com.carrot.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class pageRespositoryImp implements pageRespositoryI{
	@Autowired
	private SqlSession session;
	private static String namespace = "com.carrot.boardMapper";
	
	
	@Override
	public int totalCnt() {
		return session.selectOne( namespace + ".getTotalCnt");
	}
	@Override
	public List<BoardDTO> getPage(int page, int pageSize) {
		int startPage, endPage;
		startPage = ((page-1)*pageSize)+1;
		endPage = page*pageSize;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("startPage", startPage);
	    parameters.put("endPage", endPage);

	    System.out.println(page+ ", "+ pageSize);
	    System.out.println(parameters);
		return session.selectList(namespace+ ".getListPage", parameters);
	}
	
	@Override
	public List<BoardDTO> getSlide(int page, int pageSize) {
		int itemNum = pageSize*page;
	    System.out.println("현재 페이지 : "+page+ ", 몇 개씩 : "+ pageSize);
		return session.selectList(namespace+ ".getListSlide", itemNum);
	}
	
}
