package edu.thymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lophoc")
public class Lop {
	@Id
	@Column(name = "malh")
	private String maLH;
	
	@Column(name = "tenlh")
	private String tenLH;
	
	@Column(name = "makh")
	private String maKH;
	
	@Column(name = "manh")
	private String maNH;
	
	@Column(name = "magvcn")
	private String maGVCN;
	
	@Transient
	private String tenKH;
	
	@Transient
	private String tenNH;
	
	@Transient
	private String tenGVCN;

	public Lop(String maLH, String tenLH, String maKH, String maNH, String maGVCN, String tenKH, String tenNH,
			String tenGVCN) {
		super();
		this.maLH = maLH;
		this.tenLH = tenLH;
		this.maKH = maKH;
		this.maNH = maNH;
		this.maGVCN = maGVCN;
		this.tenKH = tenKH;
		this.tenNH = tenNH;
		this.tenGVCN = tenGVCN;
	}

	public Lop(String maLH, String tenLH, String maKH, String maNH, String maGVCN) {
		super();
		this.maLH = maLH;
		this.tenLH = tenLH;
		this.maKH = maKH;
		this.maNH = maNH;
		this.maGVCN = maGVCN;
	}

	public Lop() {
		super();
	}

	public String getMaLH() {
		return maLH;
	}

	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}

	public String getTenLH() {
		return tenLH;
	}

	public void setTenLH(String tenLH) {
		this.tenLH = tenLH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}

	public String getMaGVCN() {
		return maGVCN;
	}

	public void setMaGVCN(String maGVCN) {
		this.maGVCN = maGVCN;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getTenNH() {
		return tenNH;
	}

	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}

	public String getTenGVCN() {
		return tenGVCN;
	}

	public void setTenGVCN(String tenGVCN) {
		this.tenGVCN = tenGVCN;
	}
	
}
