package edu.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.thymeleaf.repository.HocKyRepository;

@Service
public class HocKyService {
	@Autowired
	private HocKyRepository hocKyRepository;
	
	public String getTenLHByMaHK(String maHK) {
		return hocKyRepository.findByMaHK(maHK).getTenHK();
	}

}
