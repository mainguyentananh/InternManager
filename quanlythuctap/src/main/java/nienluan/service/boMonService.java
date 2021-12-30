package nienluan.service;

import java.util.List;

import nienluan.model.boMon;

public interface boMonService {
	public List<boMon> getAllBM();
	public boMon getByID(int id);
}
