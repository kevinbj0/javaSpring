package com.acorn.web;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Program {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		run();

	}
	static void run() throws FileNotFoundException, IOException {
		System.out.println("======================음악 추천======================");
		System.out.printf("장르를 입력하세요.=> 발라드,힙합, 댄스, 락 (1입력시 종료)  ");
   
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		String title = "";
		String genre = sc.next();
		int rdm = random.nextInt(4)+1;
	    title = genre + rdm;
	    
	    Properties p = new Properties();
	    p.load(new FileReader("src/day4/과제/config.txt"));
	    String className = p.getProperty(title);
	    
	    System.out.println(className);
    }

}
