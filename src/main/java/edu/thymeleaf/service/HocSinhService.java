package edu.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.thymeleaf.model.HocSinh;
import edu.thymeleaf.repository.HocSinhRepository;

@Service
public class HocSinhService {
	@Autowired
	HocSinhRepository hocSinhRepository;
	@Autowired
	private LopService lopService;

	public List<HocSinh> listByMaLH(String maLH) {
		List<HocSinh> list = hocSinhRepository.findByMaLH(maLH);
		
		if (list != null) {
			String tenLop = lopService.getTenLHByMaLH(maLH);
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setTenLop(tenLop);
			}
		}
		
		return list;
	}
	
	public List<HocSinh> getAll() {
		List<HocSinh> list = hocSinhRepository.findAll();
		
		return list;
	}

	public HocSinh getByMaHS(String maHS) {
		return hocSinhRepository.getByMaHS(maHS);
	}

	public void update(String ho, String ten, String gioiTinh, String ngaySinh, String diaChi, String maHS) {
		hocSinhRepository.update(ho, ten, gioiTinh, ngaySinh, diaChi, maHS);
	}

	public void updateMaLH(String maHS) {
		hocSinhRepository.updateMaLH(maHS);
	}
	
	@Transactional
	public  boolean insertHocSinh(HocSinh hocSinh) {
		int length = getAll().size();
		hocSinhRepository.save(hocSinh);
		return length==(getAll().size()+1);
	}
	
	public boolean deleteByMaHS(String MaHS) {
		int length = getAll().size();
		hocSinhRepository.delete(hocSinhRepository.findByMaHS(MaHS));
		return length==(getAll().size()+1);
		
	}
	
	public void  upgradeHocSinh(HocSinh hocSinh) {
		hocSinhRepository.save(hocSinh);
		return ;
	}

}
