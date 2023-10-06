package com.acorn.day1.di;

public class ACalculator implements Calculator	{

	@Override
	public int add(int su1, int su2) {
		System.out.println("A calculator");
		return su1+su2;
	}
	
}
