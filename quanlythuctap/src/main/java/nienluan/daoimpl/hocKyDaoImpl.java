package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.hocKyDao;
import nienluan.model.hocKy;

@Repository
public class hocKyDaoImpl implements hocKyDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<hocKy> getAllHocKy() {
		Session session = sessionfactory.getCurrentSession();
		List<hocKy> list = session.createQuery("From hocKy",hocKy.class).list();
		return list;
	}

}
