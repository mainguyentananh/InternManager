package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.hocKyDao;
import nienluan.model.hocKy;

import nienluan.service.hocKyService;

@Service
@Transactional
public class hocKyServiceImpl implements hocKyService{

	@Autowired
	private hocKyDao repo;
	
	@Override
	public List<hocKy> getAllHocKy() {
		return repo.getAllHocKy();
	}

	
}
