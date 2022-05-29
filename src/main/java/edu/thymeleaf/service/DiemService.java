package edu.thymeleaf.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.thymeleaf.common.StringCommon;
import edu.thymeleaf.model.Diem;
import edu.thymeleaf.repository.DiemRepository;
import edu.thymeleaf.repository.HocKyRepository;
import edu.thymeleaf.repository.MonHocRepository;
import edu.thymeleaf.repository.NamHocRepository;
import edu.thymeleaf.repository.PhanCongRepository;

@Service
public class DiemService {
	@Autowired
	DiemRepository diemRepository;
	@Autowired
	NamHocRepository namHocRepository;
	@Autowired
	HocKyRepository hocKyRepository;
	@Autowired
	MonHocRepository monHocRepository;
	@Autowired
	PhanCongRepository phanCongRepository;
	@Autowired
	@PersistenceContext
	private EntityManager em;

	public Diem getDiemByMaHSAndMaPC(String maHS, String maPC) {
		return diemRepository.getByMaHSAndMaPC(maHS, maPC);
	}

	public void updateDiem(String maDiem, float diemHe1, float diemHe2, float diemHe3) {
		diemRepository.updateDiem(maDiem, diemHe1, diemHe2, diemHe3);
	}

	public List<Diem> getListNewByMaGV(String maGV) {
		return diemRepository.getListNewByMaGV(maGV);
	}

	public List<Diem> getListDiemByMaHS(String maHS) {
		List<Diem> list = diemRepository.getListDiemByMaHS(maHS);
		
		if (list != null) {
			for (int i = 0; i  < list.size(); i++) {
				list.get(i).setPhanCong(phanCongRepository.getByMaPC(list.get(i).getMaPC()));
				list.get(i).setHocKy(hocKyRepository.findByMaHK(list.get(i).getPhanCong().getMaHK()));
				list.get(i).setMonHoc(monHocRepository.findByMaMH(list.get(i).getPhanCong().getMaMH()));
			}
		}
		
		for (int i = 0; i  < list.size(); i++) {
			System.out.println(list.get(i).getMaHS() + list.get(i).getMonHoc().getTenMH());
		}
		
		return list;
	}
	
	public List<Diem> getAll() {
		List<Diem> list = diemRepository.findAll();
		System.out.println("giaoVienRepository.findAll().Size: "+list.size());
		
		return list;
	}

	public void save(Diem diem) {
		diemRepository.save(diem);
	}

	public String getLastMaDiem() {
		Diem diem = diemRepository.lastID();	
		String id = "";
		
		if (diem == null) {
			id = "D0001";
		} else {	
			String lastID = diem.getMaDiem();
			
			int ma = Integer.valueOf(lastID.substring(1));
			ma++;
			id = "D" + StringCommon.convertNumberToString(ma, 4);
		}
		
		return id;
	}
	
	public Diem getByMaHS(String maHS) {
		List<Diem> list = diemRepository.findAllByMaHS(maHS);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public List<Diem> getTop3StudentScore() {
		@SuppressWarnings("unchecked")
		List<Diem> list = em.createNamedStoredProcedureQuery("get_top_3_student_score").getResultList();
		
		System.out.println("diemRepository.findTop3().Size: " + list.size());
		return list;
	}

	public List<Diem> getGoodStudent() {
		@SuppressWarnings("unchecked")
		List<Diem> list = em.createNamedStoredProcedureQuery("get_good_student").getResultList();
		
		System.out.println("diemRepository.findTop3().Size: " + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> statistic_diemHe1() {
		List<Object[]> list = em.createNamedStoredProcedureQuery("statistic_diemHe1").getResultList();
		List<Integer> data = new ArrayList<Integer>(); 
		for(int i=0;i<10;i++) {
			data.add(0);
		}
		for(int i=0;i<list.size();i++)
		{
			int soluong =Integer.parseInt(list.get(i)[0].toString());
			int diem = (int)Double.parseDouble(list.get(i)[1].toString());
			data.set(diem-1, soluong);
		}
		return data;
	}
	public List<Integer> statistic_diemHe2() {
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNamedStoredProcedureQuery("statistic_diemHe2").getResultList();
		List<Integer> data = new ArrayList<Integer>(); 
		for(int i=0;i<10;i++) {
			data.add(0);
		}
		for(int i=0;i<list.size();i++)
		{
			int soluong =Integer.parseInt(list.get(i)[0].toString());
			int diem = (int)Double.parseDouble(list.get(i)[1].toString());
			data.set(diem-1, soluong);
		}
		return data;
	}
	public List<Integer> statistic_diemHe3() {
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNamedStoredProcedureQuery("statistic_diemHe3").getResultList();
		List<Integer> data = new ArrayList<Integer>(); 
		for(int i=0;i<10;i++) {
			data.add(0);
		}
		for(int i=0;i<list.size();i++)
		{
			int soluong =Integer.parseInt(list.get(i)[0].toString());
			int diem = (int)Double.parseDouble(list.get(i)[1].toString());
			data.set(diem-1, soluong);
		}
		return data;
	}

}
