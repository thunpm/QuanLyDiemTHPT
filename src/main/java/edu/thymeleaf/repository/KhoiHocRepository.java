package edu.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.thymeleaf.model.KhoiHoc;

public interface KhoiHocRepository extends JpaRepository<KhoiHoc, Long> {

	KhoiHoc findByMaKH(String maKH);
	
}
