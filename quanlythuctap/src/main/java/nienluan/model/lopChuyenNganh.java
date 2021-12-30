package nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lopchuyennganh")
public class lopChuyenNganh implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaLopCN")
	private String maLopCN;

	@ManyToOne
	@JoinColumn(name = "MaNganh")
	private nganh nganh;

	@OneToMany(mappedBy = "lopChuyenNganh")
	private List<sinhVien> sinhVien;

	public lopChuyenNganh() {

	}

	public lopChuyenNganh(String maLopCN, nienluan.model.nganh nganh, List<nienluan.model.sinhVien> sinhVien) {

		this.maLopCN = maLopCN;
		this.nganh = nganh;
		this.sinhVien = sinhVien;
	}

	public String getMaLopCN() {
		return maLopCN;
	}

	public void setMaLopCN(String maLopCN) {
		this.maLopCN = maLopCN;
	}

	public nganh getNganh() {
		return nganh;
	}

	public void setNganh(nganh nganh) {
		this.nganh = nganh;
	}

	public List<sinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<sinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

}
