package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.tuyenDungDao;
import nienluan.model.tuyenDung;
import nienluan.service.tuyenDungService;

@Service
@Transactional
public class tuyenDungServiceImpl implements tuyenDungService{

	@Autowired
	private tuyenDungDao repo;
	
	@Override
	public List<tuyenDung> getAllTuyenDung() {
		return repo.getAllTuyenDung();
	}

	@Override
	public void saveTuyenDung(tuyenDung td) {
		repo.saveTuyenDung(td);
		
	}

	@Override
	public tuyenDung getByID(int MaSoTD) {
		return repo.getByID(MaSoTD);
	}

	@Override
	public void updateTuyenDung(tuyenDung td) {
		repo.updateTuyenDung(td);
		
	}

	@Override
	public List<tuyenDung> getAllTuyenDungKhac() {
		return repo.getAllTuyenDungKhac();
	}

	@Override
	public List<tuyenDung> getAllTuyenDungHienTai() {
		return repo.getAllTuyenDungHienTai();
	}

	@Override
	public List<tuyenDung> getTuyenDung(String tenDV, String emailDV, String tinhThanhPho, String soDienThoaiDV) {
		return repo.getTuyenDung(tenDV, emailDV, tinhThanhPho, soDienThoaiDV);
	}

}
