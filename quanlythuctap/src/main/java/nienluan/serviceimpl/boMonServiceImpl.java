package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.boMonDao;
import nienluan.model.boMon;
import nienluan.service.boMonService;

@Service
@Transactional
public class boMonServiceImpl implements boMonService{

	@Autowired
	private boMonDao repo;
	
	@Override
	public List<boMon> getAllBM() {
		return repo.getAllBM();
	}

	@Override
	public boMon getByID(int id) {
		return repo.getByID(id);
	}

	
}
