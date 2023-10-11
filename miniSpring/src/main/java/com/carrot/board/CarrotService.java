package com.carrot.board;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrotService {
	
	@Autowired
	CarrotDAO dao = new CarrotDAO();
	
	public JSONArray SelectAll() {
		ArrayList<CarrotDTO> list = dao.pBoard();
		JSONArray arr = new JSONArray();
		
		for(int i = 0; i<list.size(); i++) {
			CarrotDTO g = list.get(i);
			JSONObject o = new JSONObject();
			o.put("goodsCode", g.getId());
			o.put("goodsBrand", g.getNumber());
			o.put("goodsName", g.getInfo());
			o.put("goodsPrice", g.getNewTime());
			arr.put(o);
		}
		return arr;
	}
}
