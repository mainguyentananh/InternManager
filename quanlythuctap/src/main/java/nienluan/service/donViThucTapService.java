package nienluan.service;

import java.util.List;

import nienluan.model.donViThucTap;

public interface donViThucTapService {
	public List<donViThucTap> getAllDonViThucTap();
	public void saveDonViTT(donViThucTap dv);
	public donViThucTap getById(String msdv);
}
