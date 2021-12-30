package nienluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nienluan.model.giangVien;
import nienluan.model.sinhVien;
import nienluan.model.thongTinThucTap;
import nienluan.service.giangVienService;
import nienluan.service.sinhVienService;
import nienluan.service.thongTinThucTapService;

@Controller
public class dangNhapController {

	@Autowired
	private thongTinThucTapService tts;
	
	@Autowired
	private sinhVienService svs;
	
	@Autowired
	private giangVienService gvs;
	
	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		if (error != null) {
			model.addAttribute("message",
					"<div class=\"btn btn-danger btn-sm rounded-pill\">Nhập Sai Vui Lòng Nhập Lại!</div>");
		}
		return "dangnhap";
	}

	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String dangXuat() {
		return "dangnhap";
	}
	

	
	public giangVien loadGV() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 return gvs.loadGiangVienByEmail(auth.getName());
	}
	
	
	@GetMapping(value = "/sinhvien")
	public String loginSuccessSinhVien(Model md) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		sinhVien sv = svs.loadSinhVienByEmail(auth.getName());
		thongTinThucTap tt = tts.getByMSSV(sv.getMaSoSV());
		md.addAttribute("thongTinSV",sv);
		if(tt != null)	
			if(tts.getByMSSV(sv.getMaSoSV()).getXetDuyet() == 1) {
				md.addAttribute("thongTinTT",tt);
			}
		return "sinhvien";
	}
	
	
	
	@GetMapping(value = "/giangvien")
	public String loginSuccessGiangVien(Model md) {
		md.addAttribute("info", loadGV());
		return "giangvien";
	}
	
	
	@GetMapping(value = "/quantri")
	public String loginSuccessQuanTri(Model md) {
		md.addAttribute("info", loadGV());
		return "quantri";
	}
	
	
	@GetMapping(value = "/403")
	public String accessDenied() {
	    return "403";
	  }
	
}
