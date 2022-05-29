package edu.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.thymeleaf.model.HocKy;

public interface HocKyRepository extends JpaRepository<HocKy, Long> {
	HocKy findByMaHK(String maHK);
}
