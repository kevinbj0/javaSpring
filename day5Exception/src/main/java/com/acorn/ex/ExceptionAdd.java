package com.acorn.ex;

public class ExceptionAdd {
	public static void main(String[] args) throws Exception {
	
		ExceptionAdd ex = new ExceptionAdd();

		try {
			int result = ex.add(5,-3);
			System.out.println(result);
		}catch(Exception e){
			System.out.println("음수");
			throw e;
		}
		System.out.println("정상종료");
	}
	
	public int add( int num1, int num2) throws Exception {
		if (num1 <0 || num2<0) {
			throw new Exception("0보다 커야함");
		}
		return num1+ num2;
	}
}
