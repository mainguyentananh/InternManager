package nienluan.service;

import java.util.List;

import nienluan.model.tuyenDung;

public interface tuyenDungService {
	public List<tuyenDung> getAllTuyenDung();
	public List<tuyenDung> getAllTuyenDungKhac();
	public List<tuyenDung> getAllTuyenDungHienTai();
	public void saveTuyenDung(tuyenDung td);
	public tuyenDung getByID(int MaSoTD);
	public void updateTuyenDung(tuyenDung td);
	public List<tuyenDung> getTuyenDung(String tenDV,String emailDV,String tinhThanhPho, String soDienThoaiDV);

}
