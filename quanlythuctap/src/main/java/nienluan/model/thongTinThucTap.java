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
@Table(name = "thongtinthuctap")
public class thongTinThucTap implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Pk_TTTT pk_tttt;

	@Embeddable
	public static class Pk_TTTT implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "MaSoSV")
		private String maSoSV;

		@Column(name = "MaLopHP")
		private String maLopHP;

		public String getMaSoSV() {
			return maSoSV;
		}

		public void setMaSoSV(String maSoSV) {
			this.maSoSV = maSoSV;
		}

		public String getMaLopHP() {
			return maLopHP;
		}

		public void setMaLopHP(String maLopHP) {
			this.maLopHP = maLopHP;
		}

	}

	@Column(name = "CongViec")
	private String congViec;
	
	@Column(name = "GhiChu")
	private String ghiChu;

	@Column(name = "XetDuyet")
	private int xetDuyet;

	@ManyToOne
	@JoinColumn(name = "MaSoDVTT")
	private donViThucTap donViThucTap;

	@ManyToOne
	@JoinColumn(name = "MaBoMon")
	private boMon TTTT_boMon;
	
	@ManyToOne
	@JoinColumn(name = "MaSoGV")
	private giangVien giangVien;

	@ManyToOne
	@JoinColumn(name = "MaSoSV", insertable = false, updatable = false)
	private sinhVien TTTT_sinhVien;

	@ManyToOne
	@JoinColumn(name = "MaLopHP", insertable = false, updatable = false)
	private lopHocPhan lopHocPhan;

	public thongTinThucTap() {

	}
	
	public thongTinThucTap(Pk_TTTT pk_tttt, String congViec, String ghiChu, int xetDuyet,
			nienluan.model.donViThucTap donViThucTap, boMon tTTT_boMon, nienluan.model.giangVien giangVien,
			sinhVien tTTT_sinhVien, nienluan.model.lopHocPhan lopHocPhan) {
		this.pk_tttt = pk_tttt;
		this.congViec = congViec;
		this.ghiChu = ghiChu;
		this.xetDuyet = xetDuyet;
		this.donViThucTap = donViThucTap;
		TTTT_boMon = tTTT_boMon;
		this.giangVien = giangVien;
		TTTT_sinhVien = tTTT_sinhVien;
		this.lopHocPhan = lopHocPhan;
	}




	public donViThucTap getDonViThucTap() {
		return donViThucTap;
	}

	public void setDonViThucTap(donViThucTap donViThucTap) {
		this.donViThucTap = donViThucTap;
	}

	public giangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(giangVien giangVien) {
		this.giangVien = giangVien;
	}

	public sinhVien getTTTT_sinhVien() {
		return TTTT_sinhVien;
	}

	public void setTTTT_sinhVien(sinhVien tTTT_sinhVien) {
		TTTT_sinhVien = tTTT_sinhVien;
	}

	public lopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}

	public void setLopHocPhan(lopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	public int getXetDuyet() {
		return xetDuyet;
	}

	public void setXetDuyet(int xetDuyet) {
		this.xetDuyet = xetDuyet;
	}




	public boMon getTTTT_boMon() {
		return TTTT_boMon;
	}


	public void setTTTT_boMon(boMon tTTT_boMon) {
		TTTT_boMon = tTTT_boMon;
	}

	public Pk_TTTT getPk_tttt() {
		return pk_tttt;
	}

	public void setPk_tttt(Pk_TTTT pk_tttt) {
		this.pk_tttt = pk_tttt;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


}
