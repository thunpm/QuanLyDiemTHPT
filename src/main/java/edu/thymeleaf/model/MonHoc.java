package edu.thymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monhoc")
public class MonHoc {
	@Id
	@Column(name = "mamh")
	private String maMH;
	
	@Column(name = "tenMH")
	private String tenMH;

	public MonHoc(String maMH, String tenMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
	}

	public MonHoc() {
		super();
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	
}
