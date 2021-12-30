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
@Table(name = "khoahoc")
public class khoaHoc implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaKhoaHoc")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maKhoaHoc;

	@Column(name = "TenKhoaHoc")
	private String tenKhoaHoc;

	@OneToMany(mappedBy = "khoaHoc")
	private List<sinhVien> sinhVien;

	public khoaHoc() {
	}

	public khoaHoc(int maKhoaHoc, String tenKhoaHoc, List<nienluan.model.sinhVien> sinhVien) {
		this.maKhoaHoc = maKhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.sinhVien = sinhVien;
	}

	public int getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public List<sinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<sinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

}
