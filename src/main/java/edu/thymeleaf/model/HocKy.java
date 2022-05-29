package edu.thymeleaf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hocky")
public class HocKy {
	@Id
	@Column(name = "mahk")
	private String maHK;
	
	@Column(name = "manh")
	private String maNH;
	
	@Transient
	private String tenNH;
	
	@Column(name = "tenhk")
	private String tenHK;
	
	@Column(name = "thoigianbatdau")
	private Date thoiGIanBatDau;
	
	@Column(name = "thoigianketthuc")
	private Date thoiGianKetThuc;
	
	public HocKy(String maHK, String maNH, String tenNH, String tenHK, Date thoiGIanBatDau, Date thoiGianKetThuc) {
		super();
		this.maHK = maHK;
		this.maNH = maNH;
		this.tenNH = tenNH;
		this.tenHK = tenHK;
		this.thoiGIanBatDau = thoiGIanBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public HocKy(String maHK, String maNH, String tenHK, Date thoiGIanBatDau, Date thoiGianKetThuc) {
		super();
		this.maHK = maHK;
		this.maNH = maNH;
		this.tenHK = tenHK;
		this.thoiGIanBatDau = thoiGIanBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public HocKy() {
		super();
	}

	public String getMaHK() {
		return maHK;
	}

	public void setMaHK(String maHK) {
		this.maHK = maHK;
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

	public String getTenHK() {
		return tenHK;
	}

	public void setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}

	public Date getThoiGIanBatDau() {
		return thoiGIanBatDau;
	}

	public void setThoiGIanBatDau(Date thoiGIanBatDau) {
		this.thoiGIanBatDau = thoiGIanBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
}
