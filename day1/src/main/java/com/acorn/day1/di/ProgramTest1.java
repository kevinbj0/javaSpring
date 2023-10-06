package com.acorn.day1.di;

public class ProgramTest1 {

	public static void main(String[] args) {
		
		Calculator calculator = new ACalculator();
		Program program = new Program(calculator);
		//program.setCalculator(calculator);;
		int result = program.addP(5, 3);
		System.out.println(result);
	}

}
