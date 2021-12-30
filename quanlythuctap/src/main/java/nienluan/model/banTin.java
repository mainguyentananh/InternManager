package nienluan.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bantin")
public class banTin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column(name = "TieuDe")
	private String tieuDe;
	
	@Column(name = "TomTat")
	private String tomTat;
	
	@Column(name = "NoiDung")
	private String noiDung;
	
	@Column(name = "PathFile")
	private String pathFile;
	
	@Column(name = "NgayDang")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat( pattern = "HH:mm dd/MM/yyyy")
	private Date ngayDang;

	public banTin() {
	}

	public banTin(int id, String tieuDe, String tomTat, String noiDung, String pathFile, Date ngayDang) {
		this.id = id;
		this.tieuDe = tieuDe;
		this.tomTat = tomTat;
		this.noiDung = noiDung;
		this.pathFile = pathFile;
		this.ngayDang = ngayDang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
	
	
}
