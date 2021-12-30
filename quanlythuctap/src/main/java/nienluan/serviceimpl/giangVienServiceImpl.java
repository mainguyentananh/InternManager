package nienluan.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.giangVienDao;
import nienluan.model.giangVien;
import nienluan.service.giangVienService;

@Service
@Transactional
public class giangVienServiceImpl implements giangVienService{
	
	@Autowired
	private giangVienDao repo;
	
	@Override
	public giangVien loadGiangVienByEmail(String email) {
		return repo.loadGiangVienByEmail(email);
	}

	@Override
	public List<giangVien> getAllGVByBM(int maBM) {		
		return repo.getAllGVByBM(maBM);
	}

	@Override
	public giangVien getGVByMSGV(String maSoGV) {
		return repo.getGVByMSGV(maSoGV);
	}

}
