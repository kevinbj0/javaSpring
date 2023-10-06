package com.acorn.day2.db;

public class 랩퍼클래스테스트 {
	public static void main(String[] args) {
		int a = 3;
		Integer i1 = a;
		Integer i2 = new Integer(a);
		
		//오토박싱 : 기본형 -> 객체형으로 자동으로 만들어줌
		System.out.println(i1);
		System.out.println(i2.intValue());
		
		int result = i2.intValue(); //언박싱
		System.out.println(result);
		
		Integer i3 = 9;
		Integer i4 = 10;
		
		//원래는 덧셈이 안됨 -> 언박싱해서 더해줌
		int result2 = i3+i4;
		System.out.println(result2);
	}
}
