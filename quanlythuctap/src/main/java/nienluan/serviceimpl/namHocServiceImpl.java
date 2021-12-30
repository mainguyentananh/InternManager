package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.namHocDao;
import nienluan.model.namHoc;
import nienluan.service.namHocService;

@Service
@Transactional
public class namHocServiceImpl implements namHocService{

	@Autowired
	private namHocDao repo;
	
	@Override
	public List<namHoc> getAllNamHoc() {
		return repo.getAllNamHoc();
	}

	
	
}
