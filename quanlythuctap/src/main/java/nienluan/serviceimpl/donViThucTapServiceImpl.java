package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.donViThucTapDao;
import nienluan.model.donViThucTap;
import nienluan.service.donViThucTapService;

@Service
@Transactional
public class donViThucTapServiceImpl implements donViThucTapService{

	@Autowired
	private donViThucTapDao repo;
	
	@Override
	public List<donViThucTap> getAllDonViThucTap() {
		return repo.getAllDonViThucTap();
	}

	@Override
	public void saveDonViTT(donViThucTap dv) {
		repo.saveDonViTT(dv);
		
	}

	@Override
	public donViThucTap getById(String msdv) {
		return repo.getById(msdv);
	}

}
