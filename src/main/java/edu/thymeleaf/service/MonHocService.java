package edu.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.thymeleaf.repository.MonHocRepository;
import edu.thymeleaf.model.MonHoc;

@Service
public class MonHocService {
	@Autowired
	private MonHocRepository monHocRepository;
	
	public String getTenByMaMH(String maMH) {
		return monHocRepository.findByMaMH(maMH).getTenMH();
	}
	
	public List<MonHoc> getAll() {
		List<MonHoc> list = monHocRepository.findAll();
		
		return list;
	}

}
