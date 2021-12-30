package nienluan.service;

import java.util.List;

import nienluan.model.thongTinThucTap;

public interface thongTinThucTapService {
	public thongTinThucTap getByMSSV(String mssv);
	public void updateTT(thongTinThucTap tt);
	public List<thongTinThucTap> xetDuyetThucTapBM(int boMon);

	
	//Quản Trị Phân Công BM
	public List<Object[]> phanCongBM();
	public List<thongTinThucTap> getByThongTinDonViTT(String tenDV,String tinhTP);
	public List<Object[]> daDuocPhanCongBM();
	public List<thongTinThucTap> phanCongLai(String hocKy,String maNamHoc,String tenDV,String tinhTP);
	
	//GVC phân công GV
	public List<thongTinThucTap> phanCongGV(int maBM);
	public List<Object[]> daDuocPhanCongGV();

	
	//Danh Sach Giang Day GV
	public List<thongTinThucTap> giangDayNamHocHocKy(String maSoGV,String hocKy,String maNamHoc);
	 //end
	
	//Thong Kê Quan Tri
	public List<thongTinThucTap> getThucTapNamHocKi(String namHoc, String hocKy);
	public Object[] tongSVThucTap(String namHoc, String hocKy);
	public List<Object[]> tongSVBoMonQuanLy(String namHoc, String hocKy);
	public List<Object[]> tongSVGiangVienQuanLy(String namHoc, String hocKy);
	public List<Object[]> tongSVCongTy(String namHoc, String hocKy);
	
	
	//Danh Sach Xet Duyet
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk, int xd);
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk);

}
