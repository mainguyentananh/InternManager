package nienluan.service;

import java.util.List;

import nienluan.model.banTin;

public interface banTinService {
	public List<banTin> getAllBanTin();
	public void saveBanTin(banTin bt);
	public void updateBanTin(banTin bt);
	public banTin getBanTinById(int id);
	
}
