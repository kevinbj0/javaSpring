package com.carrot.board;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class CarrotController {
    @Autowired
    CarrotService s;
    
    //메인
	@RequestMapping("/select")
	public String SearchAll()  {
		return "Carrot";
	}
    
    // 조회
    @RequestMapping(value = "/pCarrot", method = RequestMethod.GET)
    public void  pCarrot(  HttpServletResponse response  ) throws IOException {
        JSONArray list = s.SelectAll();
        response.getWriter().println( list);
        
    }
    
    
    @RequestMapping(value = "/pCarrot2", method = RequestMethod.GET)
    public void  pCarrot2(  HttpServletResponse response  ) throws IOException {
        JSONArray list = s.SelectAll();        
        response.setContentType("application/json;charset=utf-8");        
        
        response.getWriter().println( list);
    }
}
//JSONObject   a= new  JSONObject();
//a.put("Cresult", list);
