package nienluan.dao;

import java.util.List;

import nienluan.model.donViThucTap;

public interface donViThucTapDao {
	public List<donViThucTap> getAllDonViThucTap();
	
	public void saveDonViTT(donViThucTap dv);
	
	public donViThucTap getById(String msdv);
	
}
