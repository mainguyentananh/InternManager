package nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hocphan")
public class hocPhan implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaHocPhan")
	private String maHocPhan;

	@Column(name = "TenHocPhan")
	private String tenHocPhan;

	@OneToMany(mappedBy = "hocPhan")
	private List<diem> diem;

	@OneToMany(mappedBy = "LHP_hocPhan")
	private List<lopHocPhan> lopHocPhan;

	public hocPhan() {

	}

	public hocPhan(String maHocPhan, String tenHocPhan, List<nienluan.model.diem> diem,
			List<nienluan.model.lopHocPhan> lopHocPhan) {

		this.maHocPhan = maHocPhan;
		this.tenHocPhan = tenHocPhan;
		this.diem = diem;
		this.lopHocPhan = lopHocPhan;
	}

	public String getMaHocPhan() {
		return maHocPhan;
	}

	public void setMaHocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}

	public String getTenHocPhan() {
		return tenHocPhan;
	}

	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
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
