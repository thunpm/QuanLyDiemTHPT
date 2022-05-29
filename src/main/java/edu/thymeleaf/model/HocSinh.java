package edu.thymeleaf.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hocsinh")
public class HocSinh {
	@Id
	@Column(name = "mahs")
	private String maHS;
	
	@Column(name = "malh")
	private String maLH;
	
	@Column(name = "ho")
	private String ho;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "gioitinh")
	private String gioiTinh;
	
	@Column(name = "ngaysinh")
	private Date ngaySinh;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Transient
	private String tenLop;
	
	@Transient
	private Diem diemMH = new Diem();

	public HocSinh(String maHS, String maLH, String ho, String ten, String gioiTinh, Date ngaySinh, String diaChi,
			String tenLop) {
		super();
		this.maHS = maHS;
		this.maLH = maLH;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.tenLop = tenLop;
	}

	public HocSinh(String maHS, String maLH, String ho, String ten, String gioiTinh, Date ngaySinh, String diaChi) {
		super();
		this.maHS = maHS;
		this.maLH = maLH;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public HocSinh() {
		super();
	}

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public String getMaLH() {
		return maLH;
	}

	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Diem getDiemMH() {
		return diemMH;
	}

	public void setDiemMH(Diem diemMH) {
		this.diemMH = diemMH;
	}
	
}
