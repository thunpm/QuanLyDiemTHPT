package edu.thymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "namhoc")
public class NamHoc {
	@Id
	@Column(name = "manh")
	private String maNH;
	
	@Column(name = "tennh")
	private String tenNH;
	
	@Column(name = "thoigianbatdau")
	private String thoiGianBatDau;
	
	@Column(name = "thoigianketthuc")
	private String thoiGianKetThuc;

	public NamHoc(String maNH, String tenNH, String thoiGianBatDau, String thoiGianKetThuc) {
		super();
		this.maNH = maNH;
		this.tenNH = tenNH;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public NamHoc() {
		super();
	}

	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}

	public String getTenNH() {
		return tenNH;
	}

	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

}
