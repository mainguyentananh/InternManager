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
@Table(name = "sinhvien")
public class sinhVien implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSoSV")
	private String maSoSV;

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

	@Column(name = "NoiSinh")
	private String noiSinh;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "NgaySinh")
	private Date ngaySinh;

	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@ManyToOne
	@JoinColumn(name = "MaLopCN")
	private lopChuyenNganh lopChuyenNganh;

	@ManyToOne
	@JoinColumn(name = "MaKhoaHoc")
	private khoaHoc khoaHoc;

	@OneToMany(mappedBy = "diem_sinhVien")
	private List<diem> diem;

	@OneToMany(mappedBy = "TTTT_sinhVien")
	private List<thongTinThucTap> thongTinThucTap;

	public sinhVien() {
	}

	public sinhVien(String maSoSV, String hoTen, String email, String matKhau, boolean gioiTinh, String chucVu,
			String noiSinh, Date ngaySinh, String soDienThoai, nienluan.model.lopChuyenNganh lopChuyenNganh,
			nienluan.model.khoaHoc khoaHoc, List<nienluan.model.diem> diem,
			List<nienluan.model.thongTinThucTap> thongTinThucTap) {
		this.maSoSV = maSoSV;
		this.hoTen = hoTen;
		this.email = email;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.noiSinh = noiSinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.lopChuyenNganh = lopChuyenNganh;
		this.khoaHoc = khoaHoc;
		this.diem = diem;
		this.thongTinThucTap = thongTinThucTap;
	}

	public String getMaSoSV() {
		return maSoSV;
	}

	public void setMaSoSV(String maSoSV) {
		this.maSoSV = maSoSV;
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

	public lopChuyenNganh getLopChuyenNganh() {
		return lopChuyenNganh;
	}

	public void setLopChuyenNganh(lopChuyenNganh lopChuyenNganh) {
		this.lopChuyenNganh = lopChuyenNganh;
	}

	public khoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(khoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public List<diem> getDiem() {
		return diem;
	}

	public void setDiem(List<diem> diem) {
		this.diem = diem;
	}

	public List<thongTinThucTap> getThongTinThucTap() {
		return thongTinThucTap;
	}

	public void setThongTinThucTap(List<thongTinThucTap> thongTinThucTap) {
		this.thongTinThucTap = thongTinThucTap;
	}

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		String role = "ROLE_SV";
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
	
}
