package nienluan.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "giangvien")
public class giangVien implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSoGV")
	private String maSoGV;

	@Column(name = "HoTen")
	private String hoTen;

	@Column(name = "Email")
	private String email;

	@Column(name = "MatKhau")
	private String matKhau;

	@Column(name = "GioiTinh")
	private boolean gioiTinh;

	@Column(name = "ChucVu")
	private String chucVu;

	@Column(name = "ChuyenMon")
	private String chuyenMon;

	@Column(name = "NoiSinh")
	private String noiSinh;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "NgaySinh")
	private Date ngaySinh;

	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@ManyToOne
	@JoinColumn(name = "MaBoMon")
	private boMon GV_boMon;

	@OneToMany(mappedBy = "giangVien")
	private List<thongTinThucTap> thongTinThucTap;

	public giangVien() {

	}

	public giangVien(String maSoGV, String hoTen, String email, String matKhau, boolean gioiTinh, String chucVu,
			String chuyenMon, String noiSinh, Date ngaySinh, String soDienThoai, boMon gV_boMon,
			List<nienluan.model.thongTinThucTap> thongTinThucTap) {
		this.maSoGV = maSoGV;
		this.hoTen = hoTen;
		this.email = email;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.chuyenMon = chuyenMon;
		this.noiSinh = noiSinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		GV_boMon = gV_boMon;
		this.thongTinThucTap = thongTinThucTap;
	}

	public String getMaSoGV() {
		return maSoGV;
	}

	public void setMaSoGV(String maSoGV) {
		this.maSoGV = maSoGV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public boMon getGV_boMon() {
		return GV_boMon;
	}

	public void setGV_boMon(boMon gV_boMon) {
		GV_boMon = gV_boMon;
	}

	public List<thongTinThucTap> getThongTinThucTap() {
		return thongTinThucTap;
	}

	public void setThongTinThucTap(List<thongTinThucTap> thongTinThucTap) {
		this.thongTinThucTap = thongTinThucTap;
	}

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		String role = "ROLE_GV";
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(this.getChucVu().equals("Quản Trị")) {
			role = "ROLE_QT";
		}
		else if(this.getChucVu().equals("Giảng Viên Chính")) {
			role = "ROLE_GVC";
		}
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
}
