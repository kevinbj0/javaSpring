package com.acorn.day2.api;

public class Drama {
	String name;
	String actor;
	public Drama(String name, String actor) {
		super();
		this.name = name;
		this.actor = actor;
	}
	public Drama() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Drama [name=" + name + ", actor=" + actor + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}	
