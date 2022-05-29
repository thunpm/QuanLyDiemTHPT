package edu.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.thymeleaf.model.Lop;
import edu.thymeleaf.repository.KhoiHocRepository;
import edu.thymeleaf.repository.LopRepository;
import edu.thymeleaf.repository.NamHocRepository;

@Service
public class LopService {
	@Autowired
	private LopRepository lopRepository;
	@Autowired
	private KhoiHocRepository khoiHocRepository;
	@Autowired
	private NamHocRepository namHocRepository;


	public String getTenLHByMaLH(String maLH) {
		return lopRepository.findByMaLH(maLH).getTenLH();
	}
	
	public List<Lop> getAll() {
		List<Lop> list = lopRepository.findAll();
		
		return list;
	}

	public List<Lop> getListLopCN(String maGV) {
		List<Lop> list = lopRepository.findByMaGVCN(maGV);
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setTenKH(khoiHocRepository.findByMaKH(list.get(i).getMaKH()).getTenKH());
				list.get(i).setTenNH(namHocRepository.findByMaNH(list.get(i).getMaNH()).getTenNH());
			}
		}
		
		return list;
	}

	public Lop getLopCN(String maGV) {
		Lop lop = lopRepository.getLopCN(maGV);
		
		if (lop != null) {
			lop.setTenKH(khoiHocRepository.findByMaKH(lop.getMaKH()).getTenKH());
			lop.setTenNH(namHocRepository.findByMaNH(lop.getMaNH()).getTenNH());
		}
		
		return lop;
	}
	
	public void insertLop(Lop lop) {
		System.out.println(lop);
		lopRepository.save(lop);
		return;
	}
	
}
