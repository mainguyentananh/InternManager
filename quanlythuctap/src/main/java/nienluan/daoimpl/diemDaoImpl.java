package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.diemDao;
import nienluan.model.diem;

@Repository
public class diemDaoImpl implements diemDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveDiem(diem d) {
		Session session = sessionfactory.getCurrentSession();
		session.save(d);

	}

	@Override
	public diem getDiem(String maSoSV, String namHoc, String hocKy, String hocPhan) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From diem where pk_diem.maSoSV like :maSoSV "
				+ "and pk_diem.maNamHoc like :namHoc "
				+ "and pk_diem.maHocPhan like :hocPhan "
				+ "and pk_diem.maHocKy like :hocKy";
		diem d = session.createQuery(hql,diem.class)
				.setParameter("maSoSV", maSoSV)
				.setParameter("namHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.setParameter("hocPhan", hocPhan)
				.uniqueResult();
		return d;
	}

	@Override
	public List<diem> getAllByPk(String namHoc, String hocKy, String hocPhan) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From diem where pk_diem.maNamHoc like :namHoc "
				+ "and pk_diem.maHocPhan like :hocPhan "
				+ "and pk_diem.maHocKy like :hocKy";
		List<diem> l = session.createQuery(hql,diem.class)
				.setParameter("namHoc", namHoc)
				.setParameter("hocKy", hocKy)
				.setParameter("hocPhan", hocPhan)
				.list();
		return l;
	}

}
