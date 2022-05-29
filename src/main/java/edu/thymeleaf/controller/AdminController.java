package edu.thymeleaf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.thymeleaf.model.Diem;
import edu.thymeleaf.model.GiaoVien;
import edu.thymeleaf.model.HocSinh;
import edu.thymeleaf.model.Lop;
import edu.thymeleaf.model.PhanCong;
import edu.thymeleaf.service.DiemService;
import edu.thymeleaf.service.GiaoVienService;
import edu.thymeleaf.service.HocKyService;
import edu.thymeleaf.service.HocSinhService;
import edu.thymeleaf.service.LopService;
import edu.thymeleaf.service.MonHocService;
import edu.thymeleaf.service.PhanCongService;

@Controller
public class AdminController {
	@Autowired
	private PhanCongService phanCongService;
	
	@Autowired
	private LopService lopService;
	
	@Autowired
	private MonHocService monHocService;
	
	@Autowired
	private GiaoVienService giaoVienService;
	
	@Autowired
	private HocSinhService hocSinhService;
	
	@Autowired
	private DiemService diemService;
	
	@RequestMapping(value = { "/admin/home" })
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userLogin")!=null) {
			List<GiaoVien> dsGV = giaoVienService.getAll();
			List<HocSinh> dsHS = hocSinhService.getAll();
			List<Lop> dsL = lopService.getAll();
			List<PhanCong> dsPC = phanCongService.getAll();
			List<Diem> dsD = diemService.getAll();
			List<Diem> dsDT3 = diemService.getTop3StudentScore();
			List<Diem> dsHSG = diemService.getGoodStudent();
			List<Integer> ss1 = diemService.statistic_diemHe1();
			List<Integer> ss2 = diemService.statistic_diemHe2();
			List<Integer> ss3 = diemService.statistic_diemHe3();
			
			System.out.println(ss1);
			System.out.println(ss2);
			System.out.println(ss3);
			
			int[] diem = {1,2,3,4,5,6,7,8,9,10};
			model.addAttribute("diem",diem);
			model.addAttribute("diem1",ss1);
			model.addAttribute("diem2",ss2);
			model.addAttribute("diem3",ss3);
			diemService.statistic_diemHe1();
			model.addAttribute("dsGV", dsGV);
			model.addAttribute("dsHS", dsHS);
			model.addAttribute("dsL", dsL);
			model.addAttribute("dsPC", dsPC);
			model.addAttribute("dsD", dsD);
			model.addAttribute("dsDT3", dsDT3);
			model.addAttribute("dsHSG", dsHSG);
			return "admin/home";
		}
		return "/";
	}
	
	@RequestMapping(value = { "/danhsachhocsinh" }, method = RequestMethod.GET)
	public String students(Model model) {
		List<HocSinh> dsHS = hocSinhService.getAll();
		model.addAttribute("dsHS", dsHS);
		List<Lop> dsL = lopService.getAll();
		model.addAttribute("dsL", dsL);
		model.addAttribute("hocSinh", new HocSinh());
		return "admin/list-student";
	}
	
	@RequestMapping(value = { "/danhsachgiaovien" }, method = RequestMethod.GET)
	public String teachers(Model model) {
		List<GiaoVien> dsGV = giaoVienService.getAll();
		model.addAttribute("dsGV", dsGV);
		GiaoVien giaoVien = new GiaoVien();
		model.addAttribute(giaoVien);
		return "admin/list-teacher";
	}
	
	@RequestMapping(value = { "/phancong" }, method = RequestMethod.GET)
	public String assignment(Model model) {
		List<PhanCong> dsPC = phanCongService.getAll();
		model.addAttribute("dsPC", dsPC);
		model.addAttribute("phanCong",new PhanCong());
		model.addAttribute("dsMH", monHocService.getAll());
		model.addAttribute("dsGV",giaoVienService.getAll());
		model.addAttribute("dsL",lopService.getAll());
		return "admin/list-assignment";
	}
	
	@RequestMapping(value = { "/danhsachlop" }, method = RequestMethod.GET)
	public String classes(Model model) {
		List<Lop> dsL = lopService.getAll();
		model.addAttribute("dsL", dsL);
		model.addAttribute("lop",new Lop());
		List<GiaoVien> dsGV = giaoVienService.getAll();
		model.addAttribute("dsGV", dsGV);
		return "admin/list-classes";
	}
	
	@RequestMapping(value = { "/1" }, method = RequestMethod.POST)
	public String form1(Model model,@ModelAttribute("hocSinh")  HocSinh hocSinh) {
		System.out.println(hocSinh);
		System.out.println("Insert HocSinh is "+ hocSinhService.insertHocSinh(hocSinh));
		return students(model);
	}
	
	@RequestMapping(value = { "/2" }, method = RequestMethod.POST)
	public String form2(Model model,@ModelAttribute("giaoVien")  GiaoVien giaoVien) {
		System.out.println(giaoVien);
		giaoVienService.insertGiaoVien(giaoVien);
		return teachers(model);
	}
	
	@RequestMapping(value = { "/3" }, method = RequestMethod.POST)
	public String form3(Model model,@ModelAttribute("lop")  Lop lop) {
		lopService.insertLop(lop);
		return classes(model);
	}
	
	@RequestMapping(value = { "/4" }, method = RequestMethod.POST)
	public String form4(Model model,@ModelAttribute("phanCong")  PhanCong phanCong) {
		return assignment(model);
	}
	
	@RequestMapping(value = { "/deleteGiaoVien" }, method = RequestMethod.POST)
	public String form5(Model model,@ModelAttribute("giaoVien")  GiaoVien giaoVien) {
		giaoVienService.deleteGiaoVien(giaoVien);
		return teachers(model);
	}

}
