package nienluan.dao;

import java.util.List;

import nienluan.model.giangVien;

public interface giangVienDao {
	public giangVien loadGiangVienByEmail(String email);
	public List<giangVien> getAllGVByBM(int maBM);
	public giangVien getGVByMSGV(String maSoGV);
}
