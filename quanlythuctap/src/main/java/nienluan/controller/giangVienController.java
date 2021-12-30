package nienluan.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nienluan.model.diem;
import nienluan.model.diem.Pk_diem;
import nienluan.model.giangVien;
import nienluan.model.thongTinThucTap;
import nienluan.model.tuyenDung;
import nienluan.service.diemService;
import nienluan.service.giangVienService;
import nienluan.service.thongTinThucTapService;
import nienluan.service.tuyenDungService;

@Controller
@RequestMapping(value = "/giangvien")
public class giangVienController {

	@Autowired
	private diemService ds;

	@Autowired
	private giangVienService gvs;

	@Autowired
	private thongTinThucTapService tts;

	@Autowired
	private tuyenDungService tds;

	public giangVien loadGvByEmail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		return gvs.loadGiangVienByEmail(email);
	}

	@GetMapping(value = "/xetduyet")
	public String xetDuyetTheoBoMon(Model md) {
		List<thongTinThucTap> list = tts.xetDuyetThucTapBM(loadGvByEmail().getGV_boMon().getMaBoMon());
		md.addAttribute("l_thongtin", list);
		return "xetduyet";
	}

	@GetMapping(value = "/danhsachxetduyet")
	public String danhSachXetDuyet() {
		return "danhsachxetduyet";
	}

	@PostMapping(value = "/danhsachxetduyet")
	public String danhSachXetDuyet(@RequestParam(value = "namHoc") String nh, @RequestParam(value = "hocKy") String hk,
			@RequestParam(value = "xetDuyet") int xd, Model md) {
		List<thongTinThucTap> list;
		if (xd == -1)
			list = tts.danhSachXetDuyet(nh, hk);
		else
			list = tts.danhSachXetDuyet(nh, hk, xd);

		md.addAttribute("l_thongtin", list);
		return "danhsachxetduyet";
	}

	@GetMapping(value = "/xetduyet/chitietxetduyet/{mssv}")
	public String chiTietXetDuyet(@PathVariable(value = "mssv") String mssv, Model md) {
		thongTinThucTap tt = tts.getByMSSV(mssv);
		md.addAttribute("chitiet", tt);
		return "chitietxetduyet";
	}

	@PostMapping(value = "/xetduyet/xacnhanxetduyet")
	public String xacNhanXetDuyet(@RequestParam(value = "mssv") String mssv,
			@RequestParam(value = "quyetDinh") String qd, @RequestParam(value = "ghiChu") String gc) {
		thongTinThucTap tt = tts.getByMSSV(mssv);

		if (!gc.trim().equalsIgnoreCase("")) {
			tt.setGhiChu(gc);
		}
		if (qd.equalsIgnoreCase("1")) {
			tt.setXetDuyet(1);
		} else {
			tt.setXetDuyet(0);
		}

		tts.updateTT(tt);
		return "redirect:/giangvien/xetduyet";
	}

	@GetMapping(value = "/phanconggv")
	public String phanCongGV(Model md) {
		giangVien gv = loadGvByEmail();
		md.addAttribute("gvduocphancong", tts.daDuocPhanCongGV());
		md.addAttribute("tenbomon", gv.getGV_boMon().getTenBoMon());
		md.addAttribute("giangVienBM", gvs.getAllGVByBM(gv.getGV_boMon().getMaBoMon()));
		md.addAttribute("thongtintt", tts.phanCongGV(gv.getGV_boMon().getMaBoMon()));
		return "phanconggv";
	}

	@PostMapping(value = "/phanconggv/xacnhan")
	public String xacNhanPhanCongGV(@RequestParam(value = "maSoSV") String mssv,
			@RequestParam(value = "maSoGV") String msgv, Model md) {
		thongTinThucTap tt = tts.getByMSSV(mssv);
		giangVien gv = gvs.getGVByMSGV(msgv);
		String c_QT = gv.getAuthorities().get(0).getAuthority();

		if (c_QT.equalsIgnoreCase("ROLE_QT")) {
			md.addAttribute("notify", "Phân Công Giảng Viên Khác");
			return "redirect:/giangvien/phanconggv";
		}
		tt.setGiangVien(gv);
		tts.updateTT(tt);
		return "redirect:/giangvien/phanconggv";
	}

	@GetMapping(value = "/giangday")
	public String giangDaySV() {
		return "giangday";
	}

	@GetMapping(value = "/giangday/chitietsinhvien/{mssv}")
	public String giangDayChiTietSV(@PathVariable(value = "mssv") String mssv, Model md) {
		thongTinThucTap tt = tts.getByMSSV(mssv);
		md.addAttribute("chitiet", tt);

		String maSoSV = tt.getPk_tttt().getMaSoSV();
		String namHoc = tt.getLopHocPhan().getLHP_namHoc().getMaNamHoc();
		String hocKi = tt.getLopHocPhan().getLHP_hocKy().getMaHocKy();
		String hocPhan = tt.getLopHocPhan().getLHP_hocPhan().getMaHocPhan();
		diem d = ds.getDiem(maSoSV, namHoc, hocKi, hocPhan);
		if (d != null) {
			md.addAttribute("svDiem", d);
		}
		return "chitietsv";
	}

	@PostMapping(value = "/giangday")
	public String giangDaySVHocKiNamHoc(@RequestParam(value = "namHoc") String nh,
			@RequestParam(value = "hocKy") String hk, Model md) {
		giangVien gv = loadGvByEmail();
		List<thongTinThucTap> list = tts.giangDayNamHocHocKy(gv.getMaSoGV(), hk, nh);
		md.addAttribute("l_thongtin", list);
		return "giangday";
	}

	@PostMapping(value = "/nhapdiem")
	public String nhapDiem(@RequestParam(value = "namHoc") String namHoc, @RequestParam(value = "hocKy") String hocKy,
			@RequestParam(value = "hocPhan") String hocPhan, @RequestParam(value = "maSoSV") String maSoSV,
			@RequestParam(value = "diemSo") float diemSo, @RequestParam(value = "ghiChu") String ghiChu) {
		Pk_diem pkd = new Pk_diem();
		pkd.setMaSoSV(maSoSV);
		pkd.setMaHocPhan(hocPhan);
		pkd.setMaHocKy(hocKy);
		pkd.setMaNamHoc(namHoc);

		diem ndiem = new diem();
		ndiem.setPk_diem(pkd);
		ndiem.setDiem(diemSo);
		if (!ghiChu.trim().equalsIgnoreCase("")) {
			ndiem.setGhiChu(ghiChu);
		}

		ds.saveDiem(ndiem);

		return "redirect:/giangvien/giangday";
	}

	@GetMapping(value = "/tuyendung")
	public String donViTT(Model md) {
		md.addAttribute("l_tuyendung", tds.getAllTuyenDung());
		return "tuyendung";
	}

	@GetMapping(value = "/chitiettuyendung/{id}")
	public String chitietTD(Model md, @PathVariable(value = "id") int MaSoTD) {
		md.addAttribute("dv", tds.getByID(MaSoTD));
		return "chitiettuyendung";
	}

	@GetMapping(value = "/themcongty")
	public String themDonViThucTap(Model md) {
		md.addAttribute("n_donvi", new tuyenDung());
		return "themcongty";
	}

	@PostMapping(value = "/luucongty")
	public String luuDonViThucTap(@ModelAttribute(value = "n_donvi") tuyenDung td,
			@RequestParam(value = "dauTG") String dauTG, Model md) throws ParseException {
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date dauThoiGian = smf.parse(dauTG);
		td.setDauThoiGian(dauThoiGian);

		// nếu đã tồn tại
		List<tuyenDung> checkTds = tds.getTuyenDung(td.getTenDV(), td.getEmailDV(), td.getTinhThanhPho(),
				td.getSoDienThoaiDV());

		if (checkTds.isEmpty()) {
			tds.saveTuyenDung(td);
		} else {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(dauThoiGian);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(checkTds.get(0).getDauThoiGian());

			int y = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
			int m = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
			int d = c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);

			if (y > 0) {
				tds.saveTuyenDung(td);
			} else if (y == 0) {
				if (m > 0) {
					tds.saveTuyenDung(td);
				} else if (m == 0) {
					if (d > 0) {
						tds.saveTuyenDung(td);
					} else {
						md.addAttribute("notify", "Đơn vị đã tồn tại");
						return "redirect:/giangvien/tuyendung";
					}
				} else {
					md.addAttribute("notify", "Đơn vị đã tồn tại");
					return "redirect:/giangvien/tuyendung";
				}
			} else {
				md.addAttribute("notify", "Đơn vị đã tồn tại");
				return "redirect:/giangvien/tuyendung";
			}
		}
		md.addAttribute("notify", "Thêm thành công");
		return "redirect:/giangvien/tuyendung";
	}

	@GetMapping(value = "/diemso")
	public String danhSachDiemSo() {
		return "diemso";
	}

	@PostMapping(value = "/diemso")
	public String danhSachDiem(@RequestParam(value = "namHoc") String nh, @RequestParam(value = "hocKy") String hk,
			Model md) {
		giangVien gv = loadGvByEmail();
		List<thongTinThucTap> list = tts.giangDayNamHocHocKy(gv.getMaSoGV(), hk, nh);

		List<diem> list_d = new ArrayList<diem>();
		for (thongTinThucTap t : list) {
			diem d = ds.getDiem(t.getTTTT_sinhVien().getMaSoSV(), nh, hk,
					t.getLopHocPhan().getLHP_hocPhan().getMaHocPhan());
			list_d.add(d);
		}

		md.addAttribute("c_xuatFile", list_d.size());
		md.addAttribute("list_d", list_d);
		return "diemso";
	}

	@PostMapping(value = "/xuatfile")
	public String xuatFile(@RequestParam(value = "namHoc") String nh, @RequestParam(value = "hocKy") String hk,
			Model md) throws IOException {
		giangVien gv = loadGvByEmail();
		List<thongTinThucTap> list = tts.giangDayNamHocHocKy(gv.getMaSoGV(), hk, nh);

		List<diem> list_d = new ArrayList<diem>();
		for (thongTinThucTap t : list) {
			diem d = ds.getDiem(t.getTTTT_sinhVien().getMaSoSV(), nh, hk,
					t.getLopHocPhan().getLHP_hocPhan().getMaHocPhan());
			list_d.add(d);
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(gv.getMaSoGV());

		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);

		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		String tile = "Danh Sách Sinh Viên";
		firstCell.setCellValue(tile);
		firstCell.setCellStyle(style);

		// Info GV
		Row tt = sheet.createRow(rowNum++);
		Cell tt_c0 = tt.createCell(0);
		tt_c0.setCellValue("MSGV");
		tt_c0.setCellStyle(style);

		Cell tt_c1 = tt.createCell(1);
		tt_c1.setCellValue(gv.getMaSoGV());
		tt_c1.setCellStyle(style);

		Cell tt_c2 = tt.createCell(2);
		tt_c2.setCellValue("Họ Tên");
		tt_c2.setCellStyle(style);

		Cell tt_c3 = tt.createCell(3);
		tt_c3.setCellValue(gv.getHoTen());
		tt_c3.setCellStyle(style);

		// Row 2 info
		Row tt2 = sheet.createRow(rowNum++);
		Cell tt2_c0 = tt2.createCell(0);
		tt2_c0.setCellValue("Năm Học");
		tt2_c0.setCellStyle(style);

		Cell tt2_c1 = tt2.createCell(1);
		tt2_c1.setCellValue(list.get(0).getLopHocPhan().getLHP_namHoc().getNienKhoa());
		tt2_c1.setCellStyle(style);

		Cell tt2_c2 = tt2.createCell(2);
		tt2_c2.setCellValue("Học Kỳ");
		tt2_c2.setCellStyle(style);

		Cell tt2_c3 = tt2.createCell(3);
		tt2_c3.setCellValue(list.get(0).getLopHocPhan().getLHP_hocKy().getTenHocKy());
		tt2_c3.setCellStyle(style);

		// end

		Row secondRow = sheet.createRow(rowNum++);
		Cell c0 = secondRow.createCell(0);
		c0.setCellValue("STT");
		c0.setCellStyle(style);

		Cell c1 = secondRow.createCell(1);
		c1.setCellValue("MSSV");
		c1.setCellStyle(style);

		Cell c2 = secondRow.createCell(2);
		c2.setCellValue("Họ Tên");
		c2.setCellStyle(style);

		Cell c3 = secondRow.createCell(3);
		c3.setCellValue("Phái");
		c3.setCellStyle(style);

		Cell c4 = secondRow.createCell(4);
		c4.setCellValue("Điểm");
		c4.setCellStyle(style);

		Cell c5 = secondRow.createCell(5);
		c5.setCellValue("Ghi Chú");
		c5.setCellStyle(style);

		Cell c6 = secondRow.createCell(6);
		c6.setCellValue("Học Phần");
		c6.setCellStyle(style);

		int i = 1;
		for (diem d : list_d) {
			Row row = sheet.createRow(rowNum++);

			Cell cell0 = row.createCell(0);
			cell0.setCellValue(i++);
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(d.getDiem_sinhVien().getMaSoSV());
			Cell cell2 = row.createCell(2);
			cell2.setCellValue(d.getDiem_sinhVien().getHoTen());
			Cell cell3 = row.createCell(3);
			if (d.getDiem_sinhVien().isGioiTinh() == true) {
				cell3.setCellValue("Nam");
			} else {
				cell3.setCellValue("Nữ");
			}
			Cell cell4 = row.createCell(4);
			cell4.setCellValue(d.getDiem());
			Cell cell5 = row.createCell(5);
			cell5.setCellValue(d.getGhiChu());
			Cell cell6 = row.createCell(6);
			cell6.setCellValue(d.getHocPhan().getMaHocPhan());
		}

		String fName = gv.getMaSoGV() + nh + hk;
		String path = "D:\\" + fName + ".xlsx";
		FileOutputStream outputStream = new FileOutputStream(path);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

		md.addAttribute("notify", "<span class=\"text-dark h5\">Xuất File Thành Công</span>" + ": " + path);
		return "diemso";
	}

}
