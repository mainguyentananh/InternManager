package nienluan.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import nienluan.model.donViThucTap;
import nienluan.model.sinhVien;
import nienluan.model.thongTinThucTap;
import nienluan.model.tuyenDung;
import nienluan.service.donViThucTapService;
import nienluan.service.sinhVienService;
import nienluan.service.thongTinThucTapService;
import nienluan.service.tuyenDungService;

@Controller
@RequestMapping(value = "/sinhvien")
public class sinhVienController {

	@Autowired
	private ServletContext app;
	
	@Autowired
	private sinhVienService svs;

	@Autowired
	private thongTinThucTapService tts;
	
	@Autowired
	private donViThucTapService dvs;

	@Autowired
	private tuyenDungService tds;

	public sinhVien loadSvByEmail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		return svs.loadSinhVienByEmail(email);
	}
	
	
	@GetMapping(value = "/chitietcv")
	public String chiTietCV(Model md) {
		String mssv = loadSvByEmail().getMaSoSV();
		if(tts.getByMSSV(mssv) != null) {
			if(tts.getByMSSV(mssv).getGiangVien() == null) {
				md.addAttribute("notify",1);
				return "thongbao";
			}
		}else {
			md.addAttribute("notify",2);
			return "thongbao";
		}
		md.addAttribute("thongTinTT",tts.getByMSSV(mssv));
		return "chitietcv";
	}
	

	@PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String uploadCV(@RequestParam(value = "file_u") MultipartFile file,Model md)
			throws IllegalStateException, IOException {

		if(!file.isEmpty()) {
		
		String mssv = loadSvByEmail().getMaSoSV();
		thongTinThucTap thongTinTT = tts.getByMSSV(mssv);

		if (thongTinTT.getCongViec() == null) {
			// Xử Lý Đổi tên file thành mssv
			String getfilename = file.getOriginalFilename();
			String rp = getfilename.replace(".", " ");
			String[] words = rp.split("\\s");
			int index = words.length;
			String duoiMoRong = words[index - 1];// lấy đuôi file

			// Xử lí tạo thư mục lưu trữ file được up 
			String hk = thongTinTT.getLopHocPhan().getLHP_hocKy().getMaHocKy();
			String nh = thongTinTT.getLopHocPhan().getLHP_namHoc().getMaNamHoc();
			String pathFolder = hk + nh; 
			
			String path = app.getRealPath("/static/" + pathFolder);
			String fileName = mssv + "." + duoiMoRong;
			File f = new File(path, fileName);
			file.transferTo(f);
			
			String ncv = pathFolder+"/"+fileName;
			thongTinTT.setCongViec(ncv);
			tts.updateTT(thongTinTT);
			
		}else {
			String pathCV = thongTinTT.getCongViec();
			
			//cắt lần 1 lấy đường dẫn thư mục
			String rp_1 = pathCV.replace("/", " ");
			String[] words_1 = rp_1.split("\\s");
			
			int o_index = words_1.length;
			String pathFolder = words_1[0]; //HK32021
			String oldFileName = words_1[o_index-1];
			
			//Cắt lần 2 đuôi mở rộng của file được up
			String getfilename = file.getOriginalFilename();
			String rp_2 = getfilename.replace(".", " ");
			String[] words_2 = rp_2.split("\\s");
			int index = words_2.length;
			String duoiMoRong = words_2[index - 1];
			
			String path = app.getRealPath("/static/" + pathFolder);
			String fileName = mssv+"."+duoiMoRong;
			File f = new File(path, fileName);
			file.transferTo(f);
			
			
			String ncv = pathFolder + "/" + fileName;
			thongTinTT.setCongViec(ncv);
			tts.updateTT(thongTinTT);
			
			//Nếu Khác Thì Xóa file củ vd 1.jpg != 1.pdf
			if(!ncv.equalsIgnoreCase(pathCV)) {
				File f_delete = new File(path,oldFileName);
				f_delete.delete();
			}
			
		}

		return "redirect:/sinhvien";
		}
		
		md.addAttribute("notify", "Bạn Chưa Chọn File");
		return "chitietcv";
	}
	
	
	@GetMapping(value = "/capnhatsdt")
	public String capNhatSDT() {
		return "capnhatsdt";
	}
	
	@PostMapping(value = "/kiemtracapnhat")
	public String kiemTraCapNhat(@RequestParam(value = "nsoDienThoai") String sdt,
			@RequestParam(value = "cpassword") String password ,Model model) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
		sinhVien sv = loadSvByEmail();
		
		if(encoder.matches(password, sv.getMatKhau())) {
			sv.setSoDienThoai(sdt);
			svs.updateSV(sv);
			return "redirect:/sinhvien";
		}
		
		model.addAttribute("message","<div class=\"btn btn-danger btn-sm rounded-pill\">Mật Khẩu Sai!</div>");
		
		
		return "capnhatsdt";
	}
	
	@GetMapping(value = "/xacnhantt")
	public String xacNhanTT(ModelMap md) {	
		sinhVien sv = loadSvByEmail();
		
		thongTinThucTap thongTinTT= tts.getByMSSV(sv.getMaSoSV());
		if(tts.getByMSSV(sv.getMaSoSV()) != null) {
			if(thongTinTT.getDonViThucTap() != null) {
				md.addAttribute("notify",3);
				return "thongbao";
			}
		}else {
			md.addAttribute("notify",2);
			return "thongbao";
		}
		
		md.addAttribute("tuyendung", tds.getAllTuyenDungHienTai());
		return "xacnhantt";
	}

	@GetMapping(value = "/xacnhantt/donvikhac")
	public String xacNhanTTDVK(ModelMap md) {	
		sinhVien sv = loadSvByEmail();
		thongTinThucTap thongTinTT= tts.getByMSSV(sv.getMaSoSV());
		if(thongTinTT != null) {
			if(thongTinTT.getDonViThucTap() != null) {
				md.addAttribute("notify",3);
				return "thongbao";
			}
		}else {
			md.addAttribute("notify",2);
			return "thongbao";
		}
		
		md.addAttribute("tuyendungkhac", tds.getAllTuyenDungKhac());
		md.addAttribute("donvi", new donViThucTap());
		return "donvikhac";
	}
	
	@GetMapping(value = "/xacnhantt/donvimoi")
	public String xacNhanTTDonViMoi(ModelMap md) {	
		sinhVien sv = loadSvByEmail();
		thongTinThucTap thongTinTT= tts.getByMSSV(sv.getMaSoSV());
		if(thongTinTT != null) {
			if(thongTinTT.getDonViThucTap() != null) {
				md.addAttribute("notify",3);
				return "thongbao";
			}
		}else {
			md.addAttribute("notify",2);
			return "thongbao";
		}
		
		md.addAttribute("donvi", new donViThucTap());
		return "donvimoi";
	}
	
	@PostMapping(value = "/luuxacnhantt")
	public String luuThongTin(@RequestParam(value = "idTuyenDung") int idtd,@RequestParam(value = "ngayBatDau") String batDauTT) throws ParseException {
	
		sinhVien sv = loadSvByEmail();
		String mssv = sv.getMaSoSV();
		
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayBD = smf.parse(batDauTT);
		
		//get TuyenDung by ID and create new DonViThucTap
		tuyenDung td = tds.getByID(idtd);
		donViThucTap dv = new donViThucTap();
		
		dv.deepCopy(td);
		
		//saveDonViThucTap
		String maSoDVTT = "TT"+mssv;
		dv.setMaSoDVTT(maSoDVTT);
		dv.setBatDauThucTap(ngayBD);
	
		dvs.saveDonViTT(dv);
		//GetDonViTT
		donViThucTap sv_dvtt = dvs.getById(maSoDVTT);
		
		//UpdateThongTinTT 
		thongTinThucTap thongTinTT= tts.getByMSSV(mssv);
		thongTinTT.setDonViThucTap(sv_dvtt);
		tts.updateTT(thongTinTT);
		
		return "redirect:/sinhvien";
	}
	
	
	
	@PostMapping(value = "/luuxacnhantt/donvikhac")
	public String luuThongTinDVK(@RequestParam(value = "idTuyenDung") int idtd,
			@RequestParam(value = "ngayBatDau") String batDauTT, @ModelAttribute(value = "donvi") donViThucTap dv
			
			) throws ParseException {
	
		sinhVien sv = loadSvByEmail();
		String mssv = sv.getMaSoSV();
		
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayBD = smf.parse(batDauTT);
	
		tuyenDung td = tds.getByID(idtd);
		dv.deepCopy(td);
		
		String maSoDVTT = "TT"+mssv;
		//saveDonViThucTap
		
		dv.setMaSoDVTT(maSoDVTT);
		dv.setBatDauThucTap(ngayBD);
		
		dvs.saveDonViTT(dv);
		
		//GetDonViTT
		donViThucTap sv_dvtt = dvs.getById(maSoDVTT);
		
		//UpdateThongTinTT 
		thongTinThucTap thongTinTT= tts.getByMSSV(mssv);
		thongTinTT.setDonViThucTap(sv_dvtt);
		tts.updateTT(thongTinTT);
		
		return "redirect:/sinhvien";
	}
	
	@PostMapping(value = "/luuxacnhantt/donvimoi")
	public String luuThongTinDonViMoi(@ModelAttribute(value = "donvi") donViThucTap dv,@RequestParam(value = "ngayBatDau") String batDauTT) throws ParseException {
		
		sinhVien sv = loadSvByEmail();
		String mssv = sv.getMaSoSV();
		
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayBD = smf.parse(batDauTT);
		
		//saveDonViThucTap
		String maSoDVTT = "TT"+mssv;
		dv.setMaSoDVTT(maSoDVTT);
		dv.setBatDauThucTap(ngayBD);
		dvs.saveDonViTT(dv);
		
		//GetDonViTT
		donViThucTap sv_dvtt = dvs.getById(maSoDVTT);
		
		//UpdateThongTinTT 
		thongTinThucTap thongTinTT= tts.getByMSSV(mssv);
		thongTinTT.setDonViThucTap(sv_dvtt);
		tts.updateTT(thongTinTT);
		
		//Create new TuyenDung if find don't result
		tuyenDung newtd= new tuyenDung();
		List<tuyenDung> checkTds = tds.getTuyenDung(dv.getTenDV(), dv.getEmailDV(), dv.getTinhThanhPho(), dv.getSoDienThoaiDV());
		if(checkTds.isEmpty()) {
			newtd.deepCopy(dv);
			tds.saveTuyenDung(newtd);
		}else
		{
			Calendar c1 = Calendar.getInstance();
			c1.setTime(ngayBD);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(checkTds.get(0).getDauThoiGian());
			int y = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
			if(y > 0) {
				newtd.deepCopy(dv);
				tds.saveTuyenDung(newtd);
			}
			
		}
		
		return "redirect:/sinhvien";
	}

}

