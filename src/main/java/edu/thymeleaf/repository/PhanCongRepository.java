package edu.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.thymeleaf.model.PhanCong;

public interface PhanCongRepository extends JpaRepository<PhanCong, Long> {
	@Query(value = "call DanhSachMon(:id);", nativeQuery = true)
	List<PhanCong> listDanhSachMon(String id);
	
	@Query(value = "select TongSoHP(:id);", nativeQuery = true)
	int countTongHPByMaGV(String id);
	
	@Query(value = "select TongSoHPDangPT(:id);", nativeQuery = true)
	int countTongHPDangPTByMaGV(String id);

	@Query(value = "select TongSoMH(:id);", nativeQuery = true)
	int countTongMHByMaGV(String id);

	PhanCong getByMaPC(String maPC);
	
	List<PhanCong> findAll();
}
