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
@Table(name = "lophocphan")
public class lopHocPhan implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maLopHP")
	private String maLopHP;

	@Column(name = "TenLop")
	private String tenLop;

	@Column(name = "SiSo")
	private int siSo;

	@Column(name = "SiSoConLai")
	private int siSoConLai;

	@ManyToOne
	@JoinColumn(name = "MaNamHoc")
	private namHoc LHP_namHoc;

	@ManyToOne
	@JoinColumn(name = "MaHocPhan")
	private hocPhan LHP_hocPhan;
	
	@ManyToOne
	@JoinColumn(name = "MaHocKy")
	private hocKy LHP_hocKy;

	@OneToMany(mappedBy = "lopHocPhan")
	private List<thongTinThucTap> thongTinThucTap;

	public lopHocPhan() {

	}

	public lopHocPhan(String maLopHP, String tenLop, int siSo, int siSoConLai, namHoc lHP_namHoc, hocPhan lHP_hocPhan,
			hocKy lHP_hocKy, List<nienluan.model.thongTinThucTap> thongTinThucTap) {
		this.maLopHP = maLopHP;
		this.tenLop = tenLop;
		this.siSo = siSo;
		this.siSoConLai = siSoConLai;
		LHP_namHoc = lHP_namHoc;
		LHP_hocPhan = lHP_hocPhan;
		LHP_hocKy = lHP_hocKy;
		this.thongTinThucTap = thongTinThucTap;
	}

	public String getMaLopHP() {
		return maLopHP;
	}

	public void setMaLopHP(String maLopHP) {
		this.maLopHP = maLopHP;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSiSo() {
		return siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	public int getSiSoConLai() {
		return siSoConLai;
	}

	public void setSiSoConLai(int siSoConLai) {
		this.siSoConLai = siSoConLai;
	}

	public namHoc getLHP_namHoc() {
		return LHP_namHoc;
	}

	public void setLHP_namHoc(namHoc lHP_namHoc) {
		LHP_namHoc = lHP_namHoc;
	}

	public hocPhan getLHP_hocPhan() {
		return LHP_hocPhan;
	}

	public void setLHP_hocPhan(hocPhan lHP_hocPhan) {
		LHP_hocPhan = lHP_hocPhan;
	}

	public List<thongTinThucTap> getThongTinThucTap() {
		return thongTinThucTap;
	}

	public void setThongTinThucTap(List<thongTinThucTap> thongTinThucTap) {
		this.thongTinThucTap = thongTinThucTap;
	}

	public hocKy getLHP_hocKy() {
		return LHP_hocKy;
	}

	public void setLHP_hocKy(hocKy lHP_hocKy) {
		LHP_hocKy = lHP_hocKy;
	}

	
}
