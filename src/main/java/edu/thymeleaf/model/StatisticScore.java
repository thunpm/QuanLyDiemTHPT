package edu.thymeleaf.model;


public class StatisticScore {
	private int soluong;
	private float diem;
	
	public StatisticScore(int soluong, float diem) {
		super();
		this.soluong = soluong;
		this.diem = diem;
	}
	
	public int getSoluong() {
		return soluong;
	}
	
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	public float getDiem() {
		return diem;
	}
	
	public void setDiem(int diem) {
		this.diem = diem;
	}

}
