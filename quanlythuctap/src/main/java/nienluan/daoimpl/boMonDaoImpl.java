package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.boMonDao;
import nienluan.model.boMon;

@Repository
public class boMonDaoImpl implements boMonDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<boMon> getAllBM() {
		Session session = sessionfactory.getCurrentSession();
		List<boMon> l = session.createQuery("From boMon",boMon.class).list();
		return l;
	}

	@Override
	public boMon getByID(int id) {
		Session session = sessionfactory.getCurrentSession();
		boMon bm = session.get(boMon.class, id);
		return bm;
	}

}
