package com.acorn.day4.서버응답;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//생성자 생성 2줄
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	String id;
	String pw;
}
