package nienluan.service;

import nienluan.model.sinhVien;

public interface sinhVienService {
	public sinhVien loadSinhVienByEmail(String email);
	public void updateSV(sinhVien sv);
}
