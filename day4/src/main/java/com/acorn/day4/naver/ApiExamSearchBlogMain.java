package com.acorn.day4.naver;

 

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

 
public class ApiExamSearchBlogMain {
 
    public static void main(String[] args) {
     ApiExamSearchBlog api = new ApiExamSearchBlog();
     String result = api.getNaverAPI();
     System.out.println(result);
     
     //String(json의 구조를 가진) -> 진짜 JSON객체로 변환

     /*json관련 라이브러리
      * 	<dependency>
		    <groupId>org.json</groupId>
		    <artifactId>json</artifactId>
		    <version>20230227</version>
			</dependency>
      */
     
     JSONObject rjson = new JSONObject(result);
     
     System.out.println(rjson);
    }
    
    
    /*
    public String getNaverAPI() {
		String clientId = "U3GGpJswbJ8FWHgDKfSY"; //애플리케이션 클라이언트 아이디
        String clientSecret = "MLf42Yn3i8"; //애플리케이션 클라이언트 시크릿


        String text = null;
        try {
            text = URLEncoder.encode("빵", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        System.out.println(responseBody);
        
        return responseBody;
	}*/
}
