package nienluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import nienluan.model.banTin;
import nienluan.service.banTinService;
import nienluan.service.tuyenDungService;

@Controller
public class trangChuController {

	@Autowired
	private banTinService bts;
	
	@Autowired
	private tuyenDungService tds;
	
	@GetMapping(value = "/trangchu")
	public String trangChu(Model md) {
		md.addAttribute("l_banTin", bts.getAllBanTin());
		return "trangchu";
	}
	
	@GetMapping(value = "/bantin/{id}")
	public String banTin(@PathVariable(value = "id") int id,Model md) {
		banTin bt = bts.getBanTinById(id);
		if(bt.getPathFile() != null)
		{	
			String []listFile = bt.getPathFile().split(",");
			md.addAttribute("listFile", listFile);
		}
		md.addAttribute("banTin", bt);
		return "cbantin";
	}
	
	@GetMapping(value = "/donvi")
	public String donvi(Model md) {
		md.addAttribute("l_donVi", tds.getAllTuyenDung());
		return "donvi";
	}
	
	@GetMapping(value = "/donvi/{MaSoTD}")
	public String chitietdonvi(Model md,@PathVariable(value = "MaSoTD") int MaSoTD) {
		md.addAttribute("dv", tds.getByID(MaSoTD));
		return "cdonvi";
	}
	
	
	
}
