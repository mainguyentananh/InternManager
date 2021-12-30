package nienluan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tuyendung")
public class tuyenDung implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSoTD")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maSoTD;

	@Column(name = "TenDV")
	private String tenDV;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "TinhThanhPho")
	private String tinhThanhPho;

	@Column(name = "SoDienThoaiDV")
	private String soDienThoaiDV;

	@Column(name = "EmailDV")
	private String emailDV;

	@Column(name = "DiaChiWeb")
	private String diaChiWeb;

	@Column(name = "HoTenNHD")
	private String hoTenNHD;

	@Column(name = "SoDienThoaiNHD")
	private String soDienThoaiNHD;

	@Column(name = "EmailNHD")
	private String emailNHD;

	@Column(name = "MoiTruong")
	private String moiTruong;

	@Column(name = "NoiDungCV")
	private String noiDungCV;

	@Column(name = "ThoiGianTT")
	private int thoiGianTT;

	@Column(name = "SoLuongNhanSV")
	private int soLuongNhanSV;

	@Column(name = "YeuCau")
	private String yeuCau;

	@Column(name = "QuyenLoi")
	private String quyenLoi;

	@Column(name = "GhiChu")
	private String ghiChu;

	@Column(name = "TrangThai")
	private String trangThai;

	@Column(name = "check_state")
	private boolean check_state;
	
	
	@Column(name = "DauThoiGian")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dauThoiGian;

	public tuyenDung() {
	}

	public tuyenDung(int maSoTD, String tenDV, String diaChi, String tinhThanhPho, String soDienThoaiDV, String emailDV,
			String diaChiWeb, String hoTenNHD, String soDienThoaiNHD, String emailNHD, String moiTruong,
			String noiDungCV, int thoiGianTT, int soLuongNhanSV, String yeuCau, String quyenLoi, String ghiChu,
			String trangThai, boolean check_state, Date dauThoiGian) {
		
		this.maSoTD = maSoTD;
		this.tenDV = tenDV;
		this.diaChi = diaChi;
		this.tinhThanhPho = tinhThanhPho;
		this.soDienThoaiDV = soDienThoaiDV;
		this.emailDV = emailDV;
		this.diaChiWeb = diaChiWeb;
		this.hoTenNHD = hoTenNHD;
		this.soDienThoaiNHD = soDienThoaiNHD;
		this.emailNHD = emailNHD;
		this.moiTruong = moiTruong;
		this.noiDungCV = noiDungCV;
		this.thoiGianTT = thoiGianTT;
		this.soLuongNhanSV = soLuongNhanSV;
		this.yeuCau = yeuCau;
		this.quyenLoi = quyenLoi;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.check_state = check_state;
		this.dauThoiGian = dauThoiGian;
	}


	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTinhThanhPho() {
		return tinhThanhPho;
	}

	public void setTinhThanhPho(String tinhThanhPho) {
		this.tinhThanhPho = tinhThanhPho;
	}

	public String getSoDienThoaiDV() {
		return soDienThoaiDV;
	}

	public void setSoDienThoaiDV(String soDienThoaiDV) {
		this.soDienThoaiDV = soDienThoaiDV;
	}

	public String getEmailDV() {
		return emailDV;
	}

	public void setEmailDV(String emailDV) {
		this.emailDV = emailDV;
	}

	public String getDiaChiWeb() {
		return diaChiWeb;
	}

	public void setDiaChiWeb(String diaChiWeb) {
		this.diaChiWeb = diaChiWeb;
	}

	public String getHoTenNHD() {
		return hoTenNHD;
	}

	public void setHoTenNHD(String hoTenNHD) {
		this.hoTenNHD = hoTenNHD;
	}

	public String getSoDienThoaiNHD() {
		return soDienThoaiNHD;
	}

	public void setSoDienThoaiNHD(String soDienThoaiNHD) {
		this.soDienThoaiNHD = soDienThoaiNHD;
	}

	public String getEmailNHD() {
		return emailNHD;
	}

	public void setEmailNHD(String emailNHD) {
		this.emailNHD = emailNHD;
	}

	public String getMoiTruong() {
		return moiTruong;
	}

	public void setMoiTruong(String moiTruong) {
		this.moiTruong = moiTruong;
	}

	public String getNoiDungCV() {
		return noiDungCV;
	}

	public void setNoiDungCV(String noiDungCV) {
		this.noiDungCV = noiDungCV;
	}

	public int getThoiGianTT() {
		return thoiGianTT;
	}

	public void setThoiGianTT(int thoiGianTT) {
		this.thoiGianTT = thoiGianTT;
	}

	public int getSoLuongNhanSV() {
		return soLuongNhanSV;
	}

	public void setSoLuongNhanSV(int soLuongNhanSV) {
		this.soLuongNhanSV = soLuongNhanSV;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getQuyenLoi() {
		return quyenLoi;
	}

	public void setQuyenLoi(String quyenLoi) {
		this.quyenLoi = quyenLoi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getDauThoiGian() {
		return dauThoiGian;
	}

	public void setDauThoiGian(Date dauThoiGian) {
		this.dauThoiGian = dauThoiGian;
	}

	public int getMaSoTD() {
		return maSoTD;
	}

	public void setMaSoTD(int maSoTD) {
		this.maSoTD = maSoTD;
	}

	public boolean isCheck_state() {
		return check_state;
	}

	public void setCheck_state(boolean check_state) {
		this.check_state = check_state;
	}
	
	public void deepCopy(donViThucTap dv) {	
		this.dauThoiGian = dv.getBatDauThucTap();
		this.tenDV = dv.getTenDV();
		this.diaChi = dv.getDiaChi();
		this.tinhThanhPho = dv.getTinhThanhPho();
		this.soDienThoaiDV = dv.getSoDienThoaiDV();
		this.check_state = true;
		this.emailDV = dv.getEmailDV();
		this.moiTruong = dv.getMoiTruong();
	}

}
