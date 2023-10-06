package com.acorn.day2.실습;

public class Movie {
	String name;
	int price;
	
	public Movie(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", price=" + price + "]";
	}
	
}
