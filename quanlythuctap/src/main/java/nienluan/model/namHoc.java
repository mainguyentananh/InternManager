package nienluan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "namhoc")
public class namHoc implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaNamHoc")
	private String maNamHoc;

	@Column(name = "NienKhoa")
	private String nienKhoa;

	@OneToMany(mappedBy = "namHoc")
	private List<diem> diem;

	@OneToMany(mappedBy = "LHP_namHoc")
	private List<lopHocPhan> lopHocPhan;

	public namHoc() {
	}

	public namHoc(String maNamHoc, String nienKhoa, List<nienluan.model.diem> diem,
			List<nienluan.model.lopHocPhan> lopHocPhan) {
		this.maNamHoc = maNamHoc;
		this.nienKhoa = nienKhoa;
		this.diem = diem;
		this.lopHocPhan = lopHocPhan;
	}

	public String getMaNamHoc() {
		return maNamHoc;
	}

	public void setMaNamHoc(String maNamHoc) {
		this.maNamHoc = maNamHoc;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
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
