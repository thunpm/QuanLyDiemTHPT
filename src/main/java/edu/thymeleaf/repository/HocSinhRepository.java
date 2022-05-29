package edu.thymeleaf.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.thymeleaf.model.HocSinh;

public interface HocSinhRepository extends JpaRepository<HocSinh, Long> {
	List<HocSinh> findByMaLH(String maLH);

	HocSinh getByMaHS(String maHS);
	
	HocSinh findByMaHS(String maHS);
	List<HocSinh> findAll();
	boolean deleteByMaHS(String maHS);
	
	@Transactional
	@Modifying
	@Query(value = "update HocSinh hs set hs.Ho = ?1, hs.Ten = ?2, hs.GioiTinh = ?3, hs.NgaySinh = ?4, hs.DiaChi = ?5 "
			+ "where hs.MaHS = ?6", nativeQuery = true)
	void update(String ho, String ten, String gioiTinh, String ngaySinh, String diaChi, String maHS);

	@Transactional
	@Modifying
	@Query(value = "update HocSinh hs set hs.MaLH = null where hs.MaHS = ?1", nativeQuery = true)
	void updateMaLH(String maHS);
}
