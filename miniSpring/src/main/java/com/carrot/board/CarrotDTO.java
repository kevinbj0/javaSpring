package com.carrot.board;

public class CarrotDTO {
	String id;
	int number;
	String info;
	String newTime;
	
	public CarrotDTO(String id, int number, String info, String newTime) {
		super();
		this.id = id;
		this.number = number;
		this.info = info;
		this.newTime = newTime;
	}

	public CarrotDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	@Override
	public String toString() {
		return "CarrotDTO [id=" + id + ", number=" + number + ", info=" + info + ", newTime=" + newTime + "]";
	}

}
