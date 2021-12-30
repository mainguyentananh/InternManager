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
@Table(name = "nganh")
public class nganh implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MaNganh")
	private String maNganh;

	@Column(name = "TenNganh")
	private String tenNganh;

	@ManyToOne
	@JoinColumn(name = "MaBoMon")
	private boMon N_boMon;

	@OneToMany(mappedBy = "nganh")
	private List<lopChuyenNganh> lopChuyenNganh;

	public nganh() {

	}

	public nganh(String maNganh, String tenNganh, boMon n_boMon, List<nienluan.model.lopChuyenNganh> lopChuyenNganh) {

		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		N_boMon = n_boMon;
		this.lopChuyenNganh = lopChuyenNganh;
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public boMon getN_boMon() {
		return N_boMon;
	}

	public void setN_boMon(boMon n_boMon) {
		N_boMon = n_boMon;
	}

	public List<lopChuyenNganh> getLopChuyenNganh() {
		return lopChuyenNganh;
	}

	public void setLopChuyenNganh(List<lopChuyenNganh> lopChuyenNganh) {
		this.lopChuyenNganh = lopChuyenNganh;
	}

}
