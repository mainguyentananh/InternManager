package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.banTinDao;
import nienluan.model.banTin;

@Repository
public class banTinDaoImpl implements banTinDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<banTin> getAllBanTin() {
		Session session = sessionfactory.getCurrentSession();
		List<banTin> l = session.createQuery("From banTin ORDER BY id DESC",banTin.class).list();
		return l;
	}

	@Override
	public void saveBanTin(banTin bt) {
		Session session = sessionfactory.getCurrentSession();
		session.save(bt);
	}

	@Override
	public void updateBanTin(banTin bt) {
		Session session = sessionfactory.getCurrentSession();
		session.update(bt);
		
	}

	@Override
	public banTin getBanTinById(int id) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(banTin.class, id);
		
	}

	
	
}
