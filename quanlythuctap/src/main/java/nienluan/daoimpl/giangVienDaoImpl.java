package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.giangVienDao;
import nienluan.model.giangVien;

@Repository
public class giangVienDaoImpl implements giangVienDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public giangVien loadGiangVienByEmail(String email) {
		Session session = sessionfactory.getCurrentSession();
		giangVien gv = session.createQuery("from giangVien where email like :email",giangVien.class).setParameter("email", email).list().get(0);	
		return gv;
	}

	@Override
	public List<giangVien> getAllGVByBM(int maBM) {
		Session session = sessionfactory.getCurrentSession();
		List<giangVien> list = session.createQuery("from giangVien where GV_boMon.maBoMon =:maBM",giangVien.class)
				.setParameter("maBM", maBM).list();
		return list;
	}

	@Override
	public giangVien getGVByMSGV(String maSoGV) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(giangVien.class, maSoGV);
	}
	
}
