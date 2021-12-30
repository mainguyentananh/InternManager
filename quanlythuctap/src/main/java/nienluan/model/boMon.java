package nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bomon")
public class boMon implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaBoMon")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maBoMon;

	@Column(name = "TenBoMon")
	private String tenBoMon;

	@OneToMany(mappedBy = "N_boMon")
	private List<nganh> nganh;

	@OneToMany(mappedBy = "GV_boMon")
	private List<giangVien> giangVien;

	@OneToMany(mappedBy = "TTTT_boMon")
	private List<thongTinThucTap> thongTinThucTap;
	
	public boMon() {

	}

	public boMon(int maBoMon, String tenBoMon, List<nienluan.model.nganh> nganh,
			List<nienluan.model.giangVien> giangVien, List<nienluan.model.thongTinThucTap> thongTinThucTap) {
		this.maBoMon = maBoMon;
		this.tenBoMon = tenBoMon;
		this.nganh = nganh;
		this.giangVien = giangVien;
		this.thongTinThucTap = thongTinThucTap;
	}



	public int getMaBoMon() {
		return maBoMon;
	}

	public void setMaBoMon(int maBoMon) {
		this.maBoMon = maBoMon;
	}

	public String getTenBoMon() {
		return tenBoMon;
	}

	public void setTenBoMon(String tenBoMon) {
		this.tenBoMon = tenBoMon;
	}

	public List<nganh> getNganh() {
		return nganh;
	}

	public void setNganh(List<nganh> nganh) {
		this.nganh = nganh;
	}

	public List<giangVien> getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(List<giangVien> giangVien) {
		this.giangVien = giangVien;
	}

	public List<thongTinThucTap> getThongTinThucTap() {
		return thongTinThucTap;
	}

	public void setThongTinThucTap(List<thongTinThucTap> thongTinThucTap) {
		this.thongTinThucTap = thongTinThucTap;
	}

	
}
