package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.thongTinThucTapDao;
import nienluan.model.thongTinThucTap;

@Repository
public class thongTinThucTapDaoImpl implements thongTinThucTapDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public thongTinThucTap getByMSSV(String mssv) {
		Session session = sessionfactory.getCurrentSession();
		thongTinThucTap result = session
				.createQuery("From thongTinThucTap where maSoSV like :mssv", thongTinThucTap.class)
				.setParameter("mssv", mssv).uniqueResult();
		return result;
	}

	@Override
	public void updateTT(thongTinThucTap tt) {
		Session session = sessionfactory.getCurrentSession();
		session.update(tt);
	}

	@Override
	public List<thongTinThucTap> xetDuyetThucTapBM(int boMon) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap "
				+ "where TTTT_sinhVien.lopChuyenNganh.nganh.N_boMon.maBoMon =:boMon and xetDuyet>1";
		List<thongTinThucTap> result = session.createQuery(hql, thongTinThucTap.class).setParameter("boMon", boMon)
				.list();
		return result;
	}

	@Override
	public List<Object[]> phanCongBM() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*), donViThucTap.tinhThanhPho,donViThucTap.tenDV from thongTinThucTap "
				+ "where TTTT_boMon.id is null and xetDuyet=1 "
				+ "group by donViThucTap.tinhThanhPho,donViThucTap.tenDV";
		List<Object[]> o = session.createQuery(hql, Object[].class).list();
		return o;
	}

	@Override
	public List<thongTinThucTap> getByThongTinDonViTT(String tenDV, String tinhTP) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap "
				+ "where donViThucTap.tenDV like :tenDV and donViThucTap.tinhThanhPho like :tinhTP and TTTT_boMon.id is null and xetDuyet=1";
		List<thongTinThucTap> list = session.createQuery(hql, thongTinThucTap.class).setParameter("tenDV", tenDV)
				.setParameter("tinhTP", tinhTP).list();
		return list;
	}

	@Override
	public List<Object[]> daDuocPhanCongBM() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*), TTTT_boMon.tenBoMon from thongTinThucTap"
				+ " where TTTT_boMon.id!=null and giangVien.maSoGV is null " + "group by TTTT_boMon.maBoMon";
		List<Object[]> o = session.createQuery(hql, Object[].class).list();
		return o;
	}

	@Override
	public List<thongTinThucTap> phanCongGV(int maBM) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap " + "where TTTT_boMon.id=:maBM and giangVien.maSoGV is null";
		List<thongTinThucTap> list = session.createQuery(hql, thongTinThucTap.class).setParameter("maBM", maBM).list();
		return list;
	}

	@Override
	public List<Object[]> daDuocPhanCongGV() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*),giangVien.hoTen from thongTinThucTap "
				+ "where giangVien.maSoGV != null and congViec is null " + "group by giangVien.maSoGV";
		List<Object[]> o = session.createQuery(hql, Object[].class).list();
		return o;
	}

	@Override
	public List<thongTinThucTap> giangDayNamHocHocKy(String maSoGV, String hocKy, String maNamHoc) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from thongTinThucTap "
				+ "where giangVien.maSoGV like :maSoGV "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy";
		List<thongTinThucTap> l = session.createQuery(hql,thongTinThucTap.class)
				.setParameter("maSoGV", maSoGV)
				.setParameter("maNamHoc", maNamHoc)
				.setParameter("hocKy", hocKy)
				.list();
		return l;
	}

	@Override
	public List<thongTinThucTap> getThucTapNamHocKi(String namHoc, String hocKy) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from thongTinThucTap "
				+ "where xetDuyet=1 "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy";
		List<thongTinThucTap> l = session.createQuery(hql,thongTinThucTap.class)
				.setParameter("maNamHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.list();
		return l;
	}

	@Override
	public Object[] tongSVThucTap(String namHoc, String hocKy) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "select count(*),lopHocPhan.LHP_namHoc.nienKhoa,lopHocPhan.LHP_hocKy.tenHocKy from thongTinThucTap where "
				+ "xetDuyet=1 "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy "
				+ "group by lopHocPhan.LHP_hocKy.maHocKy,lopHocPhan.LHP_namHoc.maNamHoc";
		Object[] o = session.createQuery(hql,Object[].class)
				.setParameter("maNamHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.uniqueResult();
		return o;
	}

	@Override
	public List<Object[]> tongSVBoMonQuanLy(String namHoc, String hocKy) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*), TTTT_boMon.tenBoMon from thongTinThucTap"
				+ " where xetDuyet=1 "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy "
				+ "group by TTTT_boMon.maBoMon";
		List<Object[]> o = session.createQuery(hql, Object[].class)
				.setParameter("maNamHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.list();
		return o;
	}

	@Override
	public List<Object[]> tongSVGiangVienQuanLy(String namHoc, String hocKy) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*), giangVien.hoTen,giangVien.GV_boMon.tenBoMon from thongTinThucTap"
				+ " where xetDuyet=1 "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy "
				+ "group by giangVien.maSoGV";
		List<Object[]> o = session.createQuery(hql, Object[].class)
				.setParameter("maNamHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.list();
		return o;
	}

	@Override
	public List<Object[]> tongSVCongTy(String namHoc, String hocKy) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "Select count(*), donViThucTap.tenDV,donViThucTap.tinhThanhPho, TTTT_boMon.tenBoMon,giangVien.maSoGV,TTTT_boMon.maBoMon from thongTinThucTap"
				+ " where xetDuyet=1 "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy "
				+ "group by donViThucTap.tenDV,donViThucTap.tinhThanhPho";
		List<Object[]> o = session.createQuery(hql, Object[].class)
				.setParameter("maNamHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.list();
		return o;
	}

	@Override
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk, int xd) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap where xetDuyet = :xd "
				+ "and lopHocPhan.LHP_namHoc.maNamHoc like :nh "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hk";
		List<thongTinThucTap> list = session.createQuery(hql,thongTinThucTap.class)
				.setParameter("nh", nh)
				.setParameter("hk", hk)
				.setParameter("xd", xd)
				.list();
		return list;
	}

	@Override
	public List<thongTinThucTap> danhSachXetDuyet(String nh, String hk) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap where "
				+ "lopHocPhan.LHP_namHoc.maNamHoc like :nh "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hk";
		List<thongTinThucTap> list = session.createQuery(hql,thongTinThucTap.class)
				.setParameter("nh", nh)
				.setParameter("hk", hk)
				.list();
		return list;
	}

	@Override
	public List<thongTinThucTap> phanCongLai(String hocKy, String maNamHoc, String tenDV, String tinhTP) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From thongTinThucTap where lopHocPhan.LHP_namHoc.maNamHoc like :maNamHoc "
				+ "and lopHocPhan.LHP_hocKy.maHocKy like :hocKy "
				+ "and donViThucTap.tenDV like :tenDV "
				+ "and donViThucTap.tinhThanhPho like :tinhTP";
		List<thongTinThucTap> list = session.createQuery(hql,thongTinThucTap.class)
				.setParameter("maNamHoc", maNamHoc)
				.setParameter("hocKy", hocKy)
				.setParameter("tenDV", tenDV)
				.setParameter("tinhTP", tinhTP).list();
		return list;
	}

	



}
