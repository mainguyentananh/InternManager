package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.diemDao;
import nienluan.model.diem;
import nienluan.service.diemService;

@Service
@Transactional
public class diemServiceImpl implements diemService{

	@Autowired
	private diemDao repo;

	@Override
	public void saveDiem(diem d) {
		repo.saveDiem(d);
	}

	@Override
	public diem getDiem(String maSoSV, String namHoc, String hocKy, String hocPhan) {
		return repo.getDiem(maSoSV, namHoc, hocKy, hocPhan);
	}

	@Override
	public List<diem> getAllByPk(String namHoc, String hocKy, String hocPhan) {
		return repo.getAllByPk(namHoc, hocKy, hocPhan);
	}
	
}
