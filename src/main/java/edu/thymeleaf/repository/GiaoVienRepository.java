package edu.thymeleaf.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.thymeleaf.model.GiaoVien;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVien, Long> {
    List<GiaoVien> findByEmailAndMatKhau(String email, String matKhau);

	List<GiaoVien> findByEmailAndMatKhauAndRole(String email, String matKhau, String role);

	List<GiaoVien> findAllByMaGV(String maGV);

	List<GiaoVien> findAllByEmail(String email);

	List<GiaoVien> findAll();
	
	@Transactional
	@Modifying
	@Query(value = "update GiaoVien gv set gv.Ho = ?1, gv.Ten = ?2, gv.GioiTinh = ?3, gv.NgaySinh = ?4, gv.DiaChi = ?5, "
			+ "gv.Sdt = ?6 where gv.MaGV = ?7", nativeQuery = true)
	void update(String ho, String ten, String gioiTinh, String ngaySinh, String diaChi, String sdt, String id);
}