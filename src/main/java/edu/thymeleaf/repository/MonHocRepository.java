package edu.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.thymeleaf.model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, Long> {
	MonHoc findByMaMH(String maMH);
	
	List<MonHoc> findAll();
}
