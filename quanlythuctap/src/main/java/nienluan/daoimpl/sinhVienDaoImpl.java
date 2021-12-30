package nienluan.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.sinhVienDao;
import nienluan.model.sinhVien;

@Repository
public class sinhVienDaoImpl implements sinhVienDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public sinhVien loadSinhVienByEmail(String email) {
		Session session = sessionfactory.getCurrentSession();
		sinhVien sv = session.createQuery("from sinhVien where email like :email",sinhVien.class).setParameter("email", email).list().get(0);	
		return sv;
	}

	@Override
	public void updateSV(sinhVien sv) {
		Session session = sessionfactory.getCurrentSession();
		session.update(sv);		
	}
}
