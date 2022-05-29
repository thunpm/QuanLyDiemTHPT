package edu.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.thymeleaf.model.PhanCong;
import edu.thymeleaf.repository.PhanCongRepository;

@Service
public class PhanCongService {
	@Autowired
	PhanCongRepository phanCongRepository;

	public List<PhanCong> listByMaGV(String maGV) {
		return phanCongRepository.listDanhSachMon(maGV);
	}

	public int countTongHPByMaGV(String maGV) {
		return phanCongRepository.countTongHPByMaGV(maGV);
	}
	
	public int countTongHPDangPTByMaGV(String maGV) {
		return phanCongRepository.countTongHPDangPTByMaGV(maGV);
	}

	public int countTongMHByMaGV(String maGV) {
		return phanCongRepository.countTongMHByMaGV(maGV);
	}
	
	public PhanCong getByMaPC(String maPC) {
		return phanCongRepository.getByMaPC(maPC);
	}
	
	public List<PhanCong> getAll() {
		List<PhanCong> list = phanCongRepository.findAll();
		
		return list;
	}
	
	public void insertPhanCong(PhanCong phanCong) {
		phanCongRepository.save(phanCong);
		return;
	}
	
}
