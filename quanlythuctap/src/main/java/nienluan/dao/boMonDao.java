package nienluan.dao;

import java.util.List;

import nienluan.model.boMon;

public interface boMonDao {
	public List<boMon> getAllBM();
	public boMon getByID(int id);
}
