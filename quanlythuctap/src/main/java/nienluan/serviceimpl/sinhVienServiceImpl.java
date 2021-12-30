package nienluan.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.sinhVienDao;
import nienluan.model.sinhVien;
import nienluan.service.sinhVienService;


@Service
@Transactional
public class sinhVienServiceImpl implements sinhVienService{

	@Autowired
	private sinhVienDao repo;
	
	@Override
	public sinhVien loadSinhVienByEmail(String email) {
		return repo.loadSinhVienByEmail(email);
	}

	@Override
	public void updateSV(sinhVien sv) {
		repo.updateSV(sv);
		
	}
	
	
	
}
