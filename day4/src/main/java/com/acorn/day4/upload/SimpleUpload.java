package com.acorn.day4.upload;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SimpleUpload {
	String fileDir = "c:\\test\\upload\\"; //폴더가 준비돼있어야함
	
	//업로드 화면
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload-form";
	}
	
	//클라이언트 사진 -> 서버에 사진 저장
	@PostMapping("/upload")
	public String upload(String goodsCode, MultipartFile file, Model model) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			String fileRealName = file.getOriginalFilename();
			String fullPath = fileDir + fileRealName; // c:\\test\\upload\\고양이.jpg
			file.transferTo(new File(fullPath));
			model.addAttribute("fileName", fileRealName);
			
		}
		
		return "upload-ok";
	}
	
	@ResponseBody
	@RequestMapping(value = "/images/{fileName:.*}",method = RequestMethod.GET)
	public Resource imageView(@PathVariable String fileName) throws MalformedURLException {
		return new UrlResource("file:c:\\test\\upload\\" + fileName);
	}
}
