package nienluan.serviceimpl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nienluan.dao.banTinDao;
import nienluan.model.banTin;
import nienluan.service.banTinService;

@Service
@Transactional
public class banTinServiceImpl implements banTinService {

	@Autowired
	private banTinDao repo;

	@Override
	public List<banTin> getAllBanTin() {
		return repo.getAllBanTin();
	}

	@Override
	public void saveBanTin(banTin bt) {
		repo.saveBanTin(bt);

	}

	@Override
	public void updateBanTin(banTin bt) {
		repo.updateBanTin(bt);

	}

	@Override
	public banTin getBanTinById(int id) {
		return repo.getBanTinById(id);
	}

}
