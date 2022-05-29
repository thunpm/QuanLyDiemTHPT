package edu.thymeleaf.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "giaovien")
public class GiaoVien {
	@Id
	@Column(name = "magv")
	private String maGV;
	
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
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "matkhau")
	private String matKhau;
	
	@Column(name = "role")
	private String role;
	
	public GiaoVien() {
		super();
	}

	public GiaoVien(String email, String matKhau) {
		super();
		this.email = email;
		this.matKhau = matKhau;
	}

	public GiaoVien(String maGV, String ho, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt,
			String email, String matKhau, String role) {
		super();
		this.maGV = maGV;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.matKhau = matKhau;
		this.role = role;
	}

	public String getMaGV() {
		return maGV;
	}
	
	public void setMaGV(String maGV) {
		this.maGV = maGV;
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
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMatKhau() {
		return matKhau;
	}
	
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
