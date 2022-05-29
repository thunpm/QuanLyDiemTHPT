package edu.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.thymeleaf.model.NamHoc;

public interface NamHocRepository extends JpaRepository<NamHoc, Long> {

	NamHoc findByMaNH(String maNH);

}
