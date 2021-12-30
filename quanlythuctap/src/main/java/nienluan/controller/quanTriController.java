package nienluan.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import nienluan.model.banTin;
import nienluan.model.boMon;
import nienluan.model.diem;
import nienluan.model.thongTinThucTap;
import nienluan.model.tuyenDung;
import nienluan.service.banTinService;
import nienluan.service.boMonService;
import nienluan.service.diemService;
import nienluan.service.thongTinThucTapService;
import nienluan.service.tuyenDungService;

@Controller
@RequestMapping(value = "/quantri")
public class quanTriController {

	@Autowired
	private boMonService bms;

	@Autowired
	private tuyenDungService tds;

	@Autowired
	private thongTinThucTapService tts;

	@Autowired
	private banTinService bts;

	@Autowired
	private diemService ds;

	@Autowired
	private ServletContext app;

	@PostMapping(value = "/exthemcongty", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String upLoadFile(@RequestParam(value = "file_u") MultipartFile file, Model md)
			throws IllegalStateException, IOException, InvalidFormatException, ParseException {
		/*
		 * D:\java\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\
		 */
		// transferto se tu tim. neu co roi n se khong them anh

		if (!file.isEmpty()) {
			String path = app.getRealPath("/static/fileupload");
			String fileName = file.getOriginalFilename();
			File f = new File(path, fileName);
			file.transferTo(f);
			String pathfile = path + "/" + fileName;
			File f2 = new File(pathfile);
			readExcel(f2);
			return "redirect:/giangvien/tuyendung";
		} else {
			md.addAttribute("notify", "Bạn Chưa Chọn File");
			return "redirect:/giangvien/tuyendung";
		}

	}

	public void readExcel(File f2) throws IllegalStateException, IOException, InvalidFormatException, ParseException {
		Workbook workbook = new XSSFWorkbook(f2);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		while (iterator.hasNext()) {
			tuyenDung td = new tuyenDung();
			Row row = iterator.next();
			if (row.getRowNum() == 0) {
				continue;
			}

			td.setDauThoiGian(row.getCell(0).getDateCellValue());

			if (row.getCell(1) == null) {
				td.setTrangThai(null);
			} else {
				td.setTrangThai(row.getCell(1).toString());
			}

			td.setTenDV(row.getCell(2).toString());
			td.setDiaChi(row.getCell(3).toString());
			td.setTinhThanhPho(row.getCell(4).toString());
			td.setSoDienThoaiDV(row.getCell(5).toString());
			td.setEmailDV(row.getCell(6).toString());

			if (row.getCell(7) == null) {
				td.setDiaChiWeb(null);
			} else {
				td.setDiaChiWeb(row.getCell(7).toString());
			}

			td.setHoTenNHD(row.getCell(8).toString());
			td.setSoDienThoaiNHD(row.getCell(9).toString());
			td.setEmailNHD(row.getCell(10).toString());
			td.setMoiTruong(row.getCell(11).toString());
			td.setNoiDungCV(row.getCell(12).toString());

			String c13 = row.getCell(13).toString().replaceAll("^0|.0$", "");
			int parc13 = Integer.parseInt(c13);
			td.setThoiGianTT(parc13);

			String c14 = row.getCell(14).toString().replaceAll("^0|.0$", "");
			int parc14 = Integer.parseInt(c14);
			td.setSoLuongNhanSV(parc14);

			td.setYeuCau(row.getCell(15).toString());

			if (row.getCell(16) == null) {
				td.setQuyenLoi(null);
			} else {
				td.setQuyenLoi(row.getCell(16).toString());
			}

			if (row.getCell(17) == null) {
				td.setGhiChu(null);
			} else {
				td.setGhiChu(row.getCell(17).toString());
			}

			List<tuyenDung> checkTDs = tds.getTuyenDung(td.getTenDV(), td.getEmailDV(), td.getTinhThanhPho(),
					td.getSoDienThoaiDV());
			if (checkTDs.isEmpty()) {
				tds.saveTuyenDung(td);
			} else {
				// vì date file excel != date da luu vao csdl nen chuyen doi 1 chut
				Date d1 = row.getCell(0).getDateCellValue();

				SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
				Date d2 = smf.parse(checkTDs.get(0).getDauThoiGian().toString());

				Calendar c1 = Calendar.getInstance();
				c1.setTime(d1);
				Calendar c2 = Calendar.getInstance();
				c2.setTime(d2);

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
							continue;
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
		}
		workbook.close();
	}

	@GetMapping(value = "/phancongbm")
	public String phanCongBoMon(Model md) {
		md.addAttribute("chitiet", tts.daDuocPhanCongBM());
		md.addAttribute("listbomon", bms.getAllBM());
		md.addAttribute("thongke", tts.phanCongBM());
		return "phancongbm";
	}

	@PostMapping(value = "/xacnhanphancong")
	public String xacNhanPhanCong(@RequestParam(value = "tenDV") String tenDV,
			@RequestParam(value = "tinhTP") String tinhTP, @RequestParam(value = "boMon") int maBM) {
		boMon bm = bms.getByID(maBM);
		List<thongTinThucTap> list_TTTT = tts.getByThongTinDonViTT(tenDV, tinhTP);
		for (thongTinThucTap thongTinTT : list_TTTT) {
			thongTinTT.setTTTT_boMon(bm);
			tts.updateTT(thongTinTT);
		}

		return "redirect:/quantri/phancongbm";
	}

	@GetMapping(value = "/thongke")
	public String thongKe(Model md) {
		return "thongke";
	}

	@PostMapping(value = "/thongke")
	public String thongke(@RequestParam(value = "hocKy") String hk, @RequestParam(value = "namHoc") String namHoc,
			Model md) {

		md.addAttribute("tongSVCT", tts.tongSVCongTy(namHoc, hk));
		md.addAttribute("tongSV", tts.tongSVThucTap(namHoc, hk));
		md.addAttribute("tongSVBM", tts.tongSVBoMonQuanLy(namHoc, hk));
		md.addAttribute("giangVienTheoDoiSV", tts.tongSVGiangVienQuanLy(namHoc, hk));
		md.addAttribute("thongTinTT", tts.getThucTapNamHocKi(namHoc, hk));
		return "thongke";
	}

	@GetMapping(value = "/bantin")
	public String banTin(Model md) {
		md.addAttribute("l_bantin", bts.getAllBanTin());
		return "bantin";
	}

	@GetMapping(value = "/thembantin")
	public String themBanTin(Model md) {
		md.addAttribute("n_banTin", new banTin());
		return "thembantin";
	}

	@PostMapping(value = "/thembantin", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String luuBanTin(@RequestParam(value = "file_u") List<MultipartFile> l_file,
			@ModelAttribute(value = "n_banTin") banTin banTin) throws IllegalStateException, IOException {

		String path = app.getRealPath("/static/fileupload");

		// handler 1 file
		if (l_file.size() == 1 && l_file.get(0).getOriginalFilename().length() > 0) {

			String fileName = l_file.get(0).getOriginalFilename();
			File f = new File(path, fileName);

			MultipartFile file = l_file.get(0);
			file.transferTo(f);
			banTin.setPathFile(fileName);
		}

		// handler multi file
		if (l_file.size() > 1) {
			String pathFileName = "";
			for (MultipartFile file : l_file) {
				String fileName = file.getOriginalFilename();
				File f = new File(path, fileName);
				file.transferTo(f);
				pathFileName += fileName + ",";
			}
			banTin.setPathFile(pathFileName);
		}

		banTin.setNgayDang(new Date());
		bts.saveBanTin(banTin);

		return "redirect:/quantri/bantin";
	}

	@GetMapping(value = "/chitietbantin/{id}")
	public String chiTietBanTin(@PathVariable(value = "id") int id, Model md) {
		banTin bt = bts.getBanTinById(id);
		if (bt.getPathFile() != null) {
			String[] listFile = bt.getPathFile().split(",");
			md.addAttribute("listFile", listFile);
		}
		md.addAttribute("banTin", bt);

		return "chitietbantin";
	}

	@GetMapping(value = "/ketqua")
	public String ketQua(Model md) {
		return "ketqua";
	}

	@PostMapping(value = "/ketqua")
	public String danhSachKetQua(@RequestParam(value = "namHoc") String namHoc,
			@RequestParam(value = "hocKy") String hk, @RequestParam(value = "hocPhan") String hocPhan, Model md) {

		List<diem> l = ds.getAllByPk(namHoc, hk, hocPhan);
		md.addAttribute("c_xuatfile", l.size());
		md.addAttribute("l_diem", l);
		return "ketqua";
	}

	@PostMapping(value = "/xuatfile")
	public String xuatFileExcel(@RequestParam(value = "namHoc") String namHoc, @RequestParam(value = "hocKy") String hk,
			@RequestParam(value = "hocPhan") String hocPhan, Model md) throws IOException {
		List<diem> list_diem = ds.getAllByPk(namHoc, hk, hocPhan);

		String e_maNamHoc = list_diem.get(0).getNamHoc().getMaNamHoc();
		String e_maHocKy = list_diem.get(0).getHocKy().getMaHocKy();
		String e_namHoc = list_diem.get(0).getNamHoc().getNienKhoa();
		String e_hocKy = list_diem.get(0).getHocKy().getTenHocKy();
		String e_hocPhan = list_diem.get(0).getHocPhan().getTenHocPhan();
		String e_maHocPhan = list_diem.get(0).getHocPhan().getMaHocPhan();

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(e_maHocPhan);

		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);

		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		firstCell.setCellStyle(style);
		String tile = "Kết Quả Thực Tập : " + e_maHocPhan + " " + e_hocPhan + " " + e_hocKy + " " + e_namHoc;
		firstCell.setCellValue(tile);

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

		int i = 1;
		for (diem d : list_diem) {
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

		}

		String fName = e_maHocPhan + e_maNamHoc + e_maHocKy;
		String path = "D:\\" + fName + ".xlsx";
		FileOutputStream outputStream = new FileOutputStream(path);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

		md.addAttribute("notify", "<span class=\"text-dark h5\">Xuất File Thành Công</span>" + ": " + path);

		return "ketqua";
	}

	@GetMapping(value = "/danhsachphancong")
	public String danhSachPhanCong() {
		return "danhsachphancong";
	}

	@PostMapping(value = "/danhsachphancong")
	public String danhSachPhanCong(@RequestParam(value = "hocKy") String hk, @RequestParam(value = "namHoc") String nh,
			Model md) {
		md.addAttribute("l_thongtin", tts.tongSVCongTy(nh, hk));
		md.addAttribute("l_bomon", bms.getAllBM());
		return "danhsachphancong";
	}

	@PostMapping(value = "/xnphancong")
	public String xacNhanPhanCong2(@RequestParam(value = "boMon") int maBM,
			@RequestParam(value = "namHoc") String maNamHoc, @RequestParam(value = "hocKy") String hk,
			@RequestParam(value = "tenDV") String tenDV, @RequestParam(value = "tinhTP") String tinhTP) {

		boMon bm = bms.getByID(maBM);
		List<thongTinThucTap> list_TTTT = tts.phanCongLai(hk, maNamHoc, tenDV, tinhTP);
		for (thongTinThucTap thongTinTT : list_TTTT) {
			thongTinTT.setTTTT_boMon(bm);
			tts.updateTT(thongTinTT);
		}

		return "redirect:/quantri/danhsachphancong";
	}

}
