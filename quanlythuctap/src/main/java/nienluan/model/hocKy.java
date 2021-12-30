package nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hocky")
public class hocKy implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaHocKy")
	private String maHocKy;

	@Column(name = "TenHocKy")
	private String tenHocKy;

	@OneToMany(mappedBy = "hocKy")
	private List<diem> diem;

	@OneToMany(mappedBy = "LHP_hocKy")
	private List<lopHocPhan> lopHocPhan;

	public hocKy() {

	}

	public hocKy(String maHocKy, String tenHocKy, List<nienluan.model.diem> diem,
			List<nienluan.model.lopHocPhan> lopHocPhan) {
		this.maHocKy = maHocKy;
		this.tenHocKy = tenHocKy;
		this.diem = diem;
		this.lopHocPhan = lopHocPhan;
	}

	public String getMaHocKy() {
		return maHocKy;
	}

	public void setMaHocKy(String maHocKy) {
		this.maHocKy = maHocKy;
	}

	public String getTenHocKy() {
		return tenHocKy;
	}

	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}

	public List<diem> getDiem() {
		return diem;
	}

	public void setDiem(List<diem> diem) {
		this.diem = diem;
	}

	public List<lopHocPhan> getLopHocPhan() {
		return lopHocPhan;
	}

	public void setLopHocPhan(List<lopHocPhan> lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}
	
	

	

}
