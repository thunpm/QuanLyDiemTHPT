package edu.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.thymeleaf.model.GiaoVien;
import edu.thymeleaf.repository.GiaoVienRepository;

@Service
public class GiaoVienService {
	@Autowired
	private GiaoVienRepository giaoVienRepository;
	
	public boolean isValidAccount(String email, String matKhau, String role) {
		List<GiaoVien> list;
		
		if ("admin".equals(role)) {	
			list = giaoVienRepository.findByEmailAndMatKhauAndRole(email, matKhau, role);
		} else {
			list = giaoVienRepository.findByEmailAndMatKhau(email, matKhau);
		}
		
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public GiaoVien getByEmail(String email) {
		List<GiaoVien> list = giaoVienRepository.findAllByEmail(email);
		
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	public List<GiaoVien> getAll() {
		List<GiaoVien> list = giaoVienRepository.findAll();
		
		return list;
	}

	public void update(String ho, String ten, String gioiTinh, String ngaySinh, String diaChi,
			String sdt, String id) {
		giaoVienRepository.update(ho, ten, gioiTinh, ngaySinh, diaChi, sdt, id);
	}
	
	@Transactional
	public  void insertGiaoVien(GiaoVien giaoVien) {
		giaoVienRepository.save(giaoVien);
		return ;
	}
	
	public void updateGiaoVien(GiaoVien giaoVien) {
		giaoVienRepository.save(giaoVien);
		return ;
	}
	
	public void deleteGiaoVien(GiaoVien giaoVien) {
		giaoVienRepository.delete(giaoVien);
		return;
		
	}
}
