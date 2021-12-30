package nienluan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diem")
public class diem implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Pk_diem pk_diem;

	@Embeddable
	public static class Pk_diem implements Serializable {
	

		private static final long serialVersionUID = 1L;

		@Column(name = "MaSoSV")
		private String maSoSV;

		@Column(name = "MaNamHoc")
		private String maNamHoc;

		@Column(name = "MaHocPhan")
		private String maHocPhan;
		

		@Column(name = "MaHocKy")
		private String maHocKy;

		public String getMaSoSV() {
			return maSoSV;
		}

		public void setMaSoSV(String maSoSV) {
			this.maSoSV = maSoSV;
		}

		public String getMaNamHoc() {
			return maNamHoc;
		}

		public void setMaNamHoc(String maNamHoc) {
			this.maNamHoc = maNamHoc;
		}

		public String getMaHocPhan() {
			return maHocPhan;
		}

		public void setMaHocPhan(String maHocPhan) {
			this.maHocPhan = maHocPhan;
		}

		public String getMaHocKy() {
			return maHocKy;
		}

		public void setMaHocKy(String maHocKy) {
			this.maHocKy = maHocKy;
		}

		
	}

	@Column(name = "GhiChu")
	private String ghiChu;

	@Column(name = "diem")
	private float diem;

	@ManyToOne
	@JoinColumn(name = "MaSoSV",insertable=false, updatable=false)
	private sinhVien diem_sinhVien;

	@ManyToOne
	@JoinColumn(name = "MaNamHoc",insertable=false, updatable=false)
	private namHoc namHoc;

	@ManyToOne
	@JoinColumn(name = "MaHocPhan",insertable=false, updatable=false)
	private hocPhan hocPhan;
	
	@ManyToOne
	@JoinColumn(name = "MaHocKy",insertable=false, updatable=false)
	private hocKy hocKy;
	

	public diem() {

	}
	

	public diem(Pk_diem pk_diem, String ghiChu, float diem, sinhVien diem_sinhVien, nienluan.model.namHoc namHoc,
			nienluan.model.hocPhan hocPhan, nienluan.model.hocKy hocKy) {
		this.pk_diem = pk_diem;
		this.ghiChu = ghiChu;
		this.diem = diem;
		this.diem_sinhVien = diem_sinhVien;
		this.namHoc = namHoc;
		this.hocPhan = hocPhan;
		this.hocKy = hocKy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	
	public namHoc getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(namHoc namHoc) {
		this.namHoc = namHoc;
	}

	public hocPhan getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(hocPhan hocPhan) {
		this.hocPhan = hocPhan;
	}

	public Pk_diem getPk_diem() {
		return pk_diem;
	}

	public void setPk_diem(Pk_diem pk_diem) {
		this.pk_diem = pk_diem;
	}



	public sinhVien getDiem_sinhVien() {
		return diem_sinhVien;
	}



	public void setDiem_sinhVien(sinhVien diem_sinhVien) {
		this.diem_sinhVien = diem_sinhVien;
	}



	public hocKy getHocKy() {
		return hocKy;
	}



	public void setHocKy(hocKy hocKy) {
		this.hocKy = hocKy;
	}

}
