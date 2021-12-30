package nienluan.service;

import java.util.List;

import nienluan.model.giangVien;

public interface giangVienService {
	public giangVien loadGiangVienByEmail(String email);
	public List<giangVien> getAllGVByBM(int maBM);
	public giangVien getGVByMSGV(String maSoGV);
}
