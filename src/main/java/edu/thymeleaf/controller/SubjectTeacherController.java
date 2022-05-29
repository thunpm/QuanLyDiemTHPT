package edu.thymeleaf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.thymeleaf.model.Diem;
import edu.thymeleaf.model.GiaoVien;
import edu.thymeleaf.model.HocSinh;
import edu.thymeleaf.model.PhanCong;
import edu.thymeleaf.service.DiemService;
import edu.thymeleaf.service.GiaoVienService;
import edu.thymeleaf.service.HocKyService;
import edu.thymeleaf.service.HocSinhService;
import edu.thymeleaf.service.LopService;
import edu.thymeleaf.service.MonHocService;
import edu.thymeleaf.service.PhanCongService;

@Controller
public class SubjectTeacherController {
	@Autowired
	private PhanCongService phanCongService;
	@Autowired
	private LopService lopService;
	@Autowired
	private MonHocService monHocService;
	@Autowired
	private HocKyService hocKyService;
	@Autowired
	private HocSinhService hocSinhService;
	@Autowired
	private DiemService diemService;
	@Autowired
	private GiaoVienService giaoVienService;
	
	@RequestMapping(value = { "/gvbm/home" })
	public String home(Model model,
			HttpSession session) {
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		int tongHPPT = phanCongService.countTongHPByMaGV(giaoVien.getMaGV());
		int tongHPDangPT = phanCongService.countTongHPDangPTByMaGV(giaoVien.getMaGV());
		int tongMH = phanCongService.countTongMHByMaGV(giaoVien.getMaGV());
		List<Diem> list = diemService.getListNewByMaGV(giaoVien.getMaGV());
		
		model.addAttribute("tongHPPT", tongHPPT);
		model.addAttribute("tongHPDangPT", tongHPDangPT);
		model.addAttribute("tongMH", tongMH);
		model.addAttribute("list", list);
		
		return "gvbm/home";
	}
	
	@RequestMapping(value = { "/gvbm/danhsachday" })
	public String danhSachMonDay(Model model,
		HttpSession session) {
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		List<PhanCong> list = phanCongService.listByMaGV(giaoVien.getMaGV());
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			list.get(i).setTenLop(lopService.getTenLHByMaLH(list.get(i).getMaLH()));
			list.get(i).setTenMH(monHocService.getTenByMaMH(list.get(i).getMaMH()));
			list.get(i).setTenHK(hocKyService.getTenLHByMaHK(list.get(i).getMaHK()));
		}
		
		model.addAttribute("list", list);

		return "gvbm/list-subject";
	}
	
	@RequestMapping(value = { "gvbm/nhapdiem" })
	public String suaDiem(Model model,
		HttpSession session,
		@RequestParam("mapc") String maPC,
		@RequestParam("malh") String maLH,
		@RequestParam("mamh") String maMH) {
		List<HocSinh> list = hocSinhService.listByMaLH(maLH);
		
		for (int i = 0; i < list.size(); i++) {
			Diem diem = diemService.getDiemByMaHSAndMaPC(list.get(i).getMaHS(), maPC);
			if (diem != null) {
				list.get(i).setDiemMH(diem);
			} else {
				list.get(i).setDiemMH(new Diem());
			}
			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("maPC", maPC);
		model.addAttribute("maLH", maLH);
		model.addAttribute("maMH", maMH);
		model.addAttribute("tenLH", lopService.getTenLHByMaLH(maLH));
		model.addAttribute("tenMH", monHocService.getTenByMaMH(maMH));

		return "gvbm/input-scores";
	}
	
	@RequestMapping(value = { "gvbm/suadiemhocsinh" }, method = RequestMethod.POST)
	public String suaDiemHocSinh(Model model,
		HttpSession session,
		@RequestParam("mapc") String maPC,
		@RequestParam("malh") String maLH,
		@RequestParam("mamh") String maMH,
		@RequestParam("mahs") String maHS,
		@RequestParam("diemhe1") String diemHe1,
		@RequestParam("diemhe2") String diemHe2,
		@RequestParam("diemhe3") String diemHe3) {
		
		if (diemHe1 != null) {
			System.out.println(diemHe1 + diemHe2 + diemHe3);
		}
		
		Diem diem = diemService.getDiemByMaHSAndMaPC(maHS, maPC);
		
		if (diem != null) {
			diemService.updateDiem(diem.getMaDiem(), Float.parseFloat(diemHe1), Float.parseFloat(diemHe2), Float.parseFloat(diemHe3));
		} else {
			diemService.save(new Diem(diemService.getLastMaDiem(), maHS, maPC, Float.parseFloat(diemHe1), Float.parseFloat(diemHe2), Float.parseFloat(diemHe3), ""));
		}
		
		List<HocSinh> list = hocSinhService.listByMaLH(maLH);
		
		for (int i = 0; i < list.size(); i++) {
			diem = diemService.getDiemByMaHSAndMaPC(list.get(i).getMaHS(), maPC);
			if (diem != null) {
				list.get(i).setDiemMH(diem);
			} else {
				list.get(i).setDiemMH(new Diem());
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("maPC", maPC);
		model.addAttribute("maLH", maLH);
		model.addAttribute("maMH", maMH);
		model.addAttribute("tenLH", lopService.getTenLHByMaLH(maLH));
		model.addAttribute("tenMH", monHocService.getTenByMaMH(maMH));

		return "gvbm/input-scores";
	}
	
	@RequestMapping(value = { "/gvbm/thongtincanhan" })
	public String thongTin(Model model) {
		
		return "gvbm/info";
	}
	
	@RequestMapping(value = { "/gvbm/danhsachlop/{id}" })
	public String danhSachLop(Model model,
		HttpSession session,
		@PathVariable("id") String maLH) {
		System.out.println(maLH);
		List<HocSinh> list = hocSinhService.listByMaLH(maLH);
		
		model.addAttribute("list", list);
		model.addAttribute("tenLH", lopService.getTenLHByMaLH(maLH));

		return "gvbm/list-student";
	}
	
	@RequestMapping(value = { "/gvbm/suathongtincanhan" }, method = RequestMethod.POST)
	public String suaThongTin(Model model, HttpSession session,
			@RequestParam("ho") String ho,
			@RequestParam("ten") String ten,
			@RequestParam("gioiTinh") String gioiTinh,
			@RequestParam("ngaySinh") String ngaySinh,
			@RequestParam("diaChi") String diaChi,
			@RequestParam("email") String email,
			@RequestParam("sdt") String sdt) {
		
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		System.out.println(giaoVien.getEmail());
		
		giaoVienService.update(ho, ten, gioiTinh, ngaySinh, diaChi, sdt, giaoVien.getMaGV());
		
		session.setAttribute("userLogin", giaoVienService.getByEmail(email));
		
		return "gvbm/info";
	}

	
}
