package edu.thymeleaf.controller;

import java.util.ArrayList;
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
import edu.thymeleaf.model.Lop;
import edu.thymeleaf.service.DiemService;
import edu.thymeleaf.service.GiaoVienService;
import edu.thymeleaf.service.HocSinhService;
import edu.thymeleaf.service.LopService;

@Controller
public class FormTeacherController {
	@Autowired
	private LopService lopService;
	@Autowired
	private GiaoVienService giaoVienService;
	@Autowired
	private HocSinhService hocSinhService;
	@Autowired
	private DiemService diemService;
	
	@RequestMapping(value = { "/gvcn/home", "/gvcn"})
	public String home(Model model, HttpSession session) {
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		List<Lop> listLopCN = lopService.getListLopCN(giaoVien.getMaGV());
		Lop lopCN = lopService.getLopCN(giaoVien.getMaGV());
		
		if (listLopCN == null) {
			model.addAttribute("tongLopCN", 0);
		} else {
			model.addAttribute("tongLopCN", listLopCN.size());
		}
	
		if (lopCN == null) {
			model.addAttribute("lopCN", "Không có thông tin");
		} else {
			model.addAttribute("lopCN", lopCN.getTenLH());
		}

		return "gvcn/home";
	}
	
	@RequestMapping(value = { "/gvcn/danhsachlop" })
	public String listLop(Model model, HttpSession session) {
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		List<Lop> listLopCN = lopService.getListLopCN(giaoVien.getMaGV());
		
		if (listLopCN == null) {
			model.addAttribute("list", new ArrayList<Lop>());
		} else {
			model.addAttribute("list", listLopCN);
		}
		
		return "gvcn/list-class";
	}
	
	@RequestMapping(value = { "/gvcn/danhsachlop/danhsachhocsinh/{id}" })
	public String danhSachLop(Model model,
		HttpSession session,
		@PathVariable("id") String maLH) {
		
		List<HocSinh> list = hocSinhService.listByMaLH(maLH);
		
		model.addAttribute("list", list);
		model.addAttribute("tenLH", lopService.getTenLHByMaLH(maLH));

		return "gvcn/list-student";
	}
	
	@RequestMapping(value = { "/gvcn/danhsachhocsinh" })
	public String danhSachHocSinh(Model model,
		HttpSession session) {
		
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		Lop lopCN = lopService.getLopCN(giaoVien.getMaGV());
		List<HocSinh> list;
		
		if (lopCN == null) {
			model.addAttribute("lopCN", null);
			
			list = null;
		} else {
			list = hocSinhService.listByMaLH(lopCN.getMaLH());
			
			model.addAttribute("lopCN", lopCN);
		}
		model.addAttribute("list", list);
		
		return "gvcn/list-student-head";
	}
	
	@RequestMapping(value = { "/gvcn/danhsachhocsinh/suahocsinh" }, method = RequestMethod.POST)
	public String suaThongTinHocSinh(Model model, HttpSession session,
			@RequestParam("maHS") String maHS,
			@RequestParam("ho") String ho,
			@RequestParam("ten") String ten,
			@RequestParam("gioiTinh") String gioiTinh,
			@RequestParam("ngaySinh") String ngaySinh,
			@RequestParam("diaChi") String diaChi) {
		
		hocSinhService.update(ho, ten, gioiTinh, ngaySinh, diaChi, maHS);
		
		return danhSachHocSinh(model, session);
	}
	
	@RequestMapping(value = { "/gvcn/danhsachhocsinh/xemdiem/{id}" })
	public String danhSachDiemHocSinh(Model model,
		HttpSession session,
		@PathVariable("id") String maHS) {
		
		GiaoVien giaoVien = (GiaoVien) session.getAttribute("userLogin");
		
		Lop lopCN = lopService.getLopCN(giaoVien.getMaGV());
		
		List<Diem> list = diemService.getListDiemByMaHS(maHS);
		
		model.addAttribute("list", list);
		model.addAttribute("student", hocSinhService.getByMaHS(maHS));
		model.addAttribute("lopCN", lopCN);
		
		return "gvcn/student-mark";
	}
	
	@RequestMapping(value = { "/gvcn/danhsachhocsinh/xoa/{id}" })
	public String xoaHocSinh(Model model,
		HttpSession session,
		@PathVariable("id") String maHS) {
		
		hocSinhService.updateMaLH(maHS);
		
		return danhSachHocSinh(model, session);
	}
	
	@RequestMapping(value = { "/gvcn/thongtincanhan" })
	public String thongTin(Model model) {
		
		return "gvcn/info";
	}
	
	@RequestMapping(value = { "/gvcn/suathongtincanhan" }, method = RequestMethod.POST)
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
		
		return "gvcn/info";
	}


}
