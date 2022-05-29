package edu.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.thymeleaf.model.Lop;

public interface LopRepository extends JpaRepository<Lop, Long> {
	Lop findByMaLH(String maLH);

	List<Lop> findByMaGVCN(String maGV);
	
	@Query(value = "call LopChuNhiem(:id);", nativeQuery = true)
	Lop getLopCN(String id);
	
	List<Lop> findAll();
}
