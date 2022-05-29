package edu.thymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "phanconggiangday")
public class PhanCong {
	@Id
	@Column(name = "mapc")
	private String maPC;
	
	@Column(name = "magv")
	private String maGV;
	
	@Column(name = "malh")
	private String maLH;
	
	@Transient
	private String tenLop;
	
	@Column(name = "mahk")
	private String maHK;
	
	@Transient
	private String tenHK;
	
	@Column(name = "mamh")
	private String maMH;
	
	@Transient
	private String tenMH;
	
	@Column(name = "ghichu")
	private String ghiChu;
	
	public PhanCong(String maPC, String maGV, String maLH, String tenLop, String maHK, String tenHK, String maMH,
			String tenMH, String ghiChu) {
		super();
		this.maPC = maPC;
		this.maGV = maGV;
		this.maLH = maLH;
		this.tenLop = tenLop;
		this.maHK = maHK;
		this.tenHK = tenHK;
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.ghiChu = ghiChu;
	}

	public PhanCong(String maPC, String maGV, String maLH, String maHK, String maMH, String ghiChu) {
		super();
		this.maPC = maPC;
		this.maGV = maGV;
		this.maLH = maLH;
		this.maHK = maHK;
		this.maMH = maMH;
		this.ghiChu = ghiChu;
	}

	public PhanCong() {
		super();
	}

	public String getMaPC() {
		return maPC;
	}

	public void setMaPC(String maPC) {
		this.maPC = maPC;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getMaLH() {
		return maLH;
	}

	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}

	public String getMaHK() {
		return maHK;
	}

	public void setMaHK(String maHK) {
		this.maHK = maHK;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenHK() {
		return tenHK;
	}

	public void setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	
	@Override
	public String toString() {
		return "PhanCong [maPC=" + maPC + ", maGV=" + maGV + ", maLH=" + maLH + ", tenLop=" + tenLop + ", maHK=" + maHK
				+ ", tenHK=" + tenHK + ", maMH=" + maMH + ", tenMH=" + tenMH + ", ghiChu=" + ghiChu + "]";
	}
	
}
