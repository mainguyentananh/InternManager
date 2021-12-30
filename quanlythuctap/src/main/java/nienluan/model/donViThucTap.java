package nienluan.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "donvithuctap")
public class donViThucTap implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSoDVTT")
	private String maSoDVTT;
	
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

	@Column(name = "HoTro")
	private String hoTro;

	@Column(name = "GhiChu")
	private String ghiChu;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "BatDauThucTap")
	private Date batDauThucTap;


	@OneToMany(mappedBy = "donViThucTap")
	private List<thongTinThucTap> thongTinThucTap;

	public donViThucTap() {

	}

	public donViThucTap(String maSoDVTT, String tenDV, String diaChi, String tinhThanhPho, String soDienThoaiDV,
			String emailDV, String hoTenNHD, String soDienThoaiNHD, String emailNHD, String moiTruong, String noiDungCV,
			int thoiGianTT, String hoTro, String ghiChu, Date batDauThucTap,
			List<nienluan.model.thongTinThucTap> thongTinThucTap) {
		this.maSoDVTT = maSoDVTT;
		this.tenDV = tenDV;
		this.diaChi = diaChi;
		this.tinhThanhPho = tinhThanhPho;
		this.soDienThoaiDV = soDienThoaiDV;
		this.emailDV = emailDV;
		this.hoTenNHD = hoTenNHD;
		this.soDienThoaiNHD = soDienThoaiNHD;
		this.emailNHD = emailNHD;
		this.moiTruong = moiTruong;
		this.noiDungCV = noiDungCV;
		this.thoiGianTT = thoiGianTT;
		this.hoTro = hoTro;
		this.ghiChu = ghiChu;
		this.batDauThucTap = batDauThucTap;
		this.thongTinThucTap = thongTinThucTap;
	}

	public Date getBatDauThucTap() {
		return batDauThucTap;
	}

	public void setBatDauThucTap(Date batDauThucTap) {
		this.batDauThucTap = batDauThucTap;
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


	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	public List<thongTinThucTap> getThongTinThucTap() {
		return thongTinThucTap;
	}

	public void setThongTinThucTap(List<thongTinThucTap> thongTinThucTap) {
		this.thongTinThucTap = thongTinThucTap;
	}
	


	public String getMaSoDVTT() {
		return maSoDVTT;
	}


	public void setMaSoDVTT(String maSoDVTT) {
		this.maSoDVTT = maSoDVTT;
	}

	public String getHoTro() {
		return hoTro;
	}

	public void setHoTro(String hoTro) {
		this.hoTro = hoTro;
	}

	public void deepCopy(tuyenDung td) {
		this.tenDV = td.getTenDV();
		this.diaChi = td.getDiaChi();
		this.tinhThanhPho = td.getTinhThanhPho();
		this.soDienThoaiDV = td.getSoDienThoaiDV();
		this.emailDV = td.getEmailDV();
		this.moiTruong = td.getMoiTruong();
	}
	

	
}

