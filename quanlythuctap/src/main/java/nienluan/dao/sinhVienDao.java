package nienluan.dao;

import nienluan.model.sinhVien;

public interface sinhVienDao {
	public sinhVien loadSinhVienByEmail(String email);
	public void updateSV(sinhVien sv);
}
