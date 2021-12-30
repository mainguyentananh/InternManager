package nienluan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.thongTinThucTapDao;
import nienluan.model.thongTinThucTap;
import nienluan.service.thongTinThucTapService;

@Service
@Transactional
public class thongTinThucTapServiceImpl implements thongTinThucTapService{

	@Autowired
	private thongTinThucTapDao repo;
	
	@Override
	public thongTinThucTap getByMSSV(String mssv) {
		return repo.getByMSSV(mssv);
	}

	@Override
	public void updateTT(thongTinThucTap tt) {
		repo.updateTT(tt);
		
	}

	@Override
	public List<thongTinThucTap> xetDuyetThucTapBM(int boMon) {
		return repo.xetDuyetThucTapBM(boMon);
	}


	@Override
	public List<Object[]> phanCongBM() {
		return repo.phanCongBM();
	}

	@Override
	public List<thongTinThucTap> getByThongTinDonViTT(String tenDV, String tinhTP) {
		return repo.getByThongTinDonViTT(tenDV, tinhTP);
	}

	@Override
	public List<Object[]> daDuocPhanCongBM() {
		return repo.daDuocPhanCongBM();
	}

	@Override
	public List<thongTinThucTap> phanCongGV(int maBM) {
		return repo.phanCongGV(maBM);
	}

	@Override
	public List<Object[]> daDuocPhanCongGV() {
		return repo.daDuocPhanCongGV();
	}

	@Override
	public List<thongTinThucTap> giangDayNamHocHocKy(String maSoGV, String hocKy, String maNamHoc) {
		return repo.giangDayNamHocHocKy(maSoGV, hocKy, maNamHoc);
	}

	@Override
	public List<thongTinThucTap> getThucTapNamHocKi(String namHoc, String hocKy) {
		return repo.getThucTapNamHocKi(namHoc, hocKy);
	}

	@Override
	public Object[] tongSVThucTap(String namHoc, String hocKy) {
		return repo.tongSVThucTap(namHoc, hocKy);
	}

	@Override
	public List<Object[]> tongSVBoMonQuanLy(String namHoc, String hocKy) {
		return repo.tongSVBoMonQuanLy(namHoc, hocKy);
	}

	@Override
	public List<Object[]> tongSVGiangVienQuanLy(String namHoc, String hocKy) {
		return repo.tongSVGiangVienQuanLy(namHoc, hocKy);
	}

	@Override
	public List<Object[]> tongSVCongTy(String namHoc, String hocKy) {
		return repo.tongSVCongTy(namHoc, hocKy);
	}

	@Override
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk, int xd) {
		return repo.danhSachXetDuyet(nh, hk, xd);
	}

	@Override
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk) {
		return repo.danhSachXetDuyet(nh, hk);
	}

	@Override
	public List<thongTinThucTap> phanCongLai(String hocKy, String maNamHoc, String tenDV, String tinhTP) {
		return repo.phanCongLai(hocKy, maNamHoc, tenDV, tinhTP);
	}


	
}
