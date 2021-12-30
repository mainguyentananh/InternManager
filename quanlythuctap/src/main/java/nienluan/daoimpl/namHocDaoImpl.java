package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.namHocDao;
import nienluan.model.namHoc;

@Repository
public class namHocDaoImpl implements namHocDao{

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<namHoc> getAllNamHoc() {
		Session session = sessionfactory.getCurrentSession();
		List<namHoc> list = session.createQuery("From namHoc",namHoc.class).list();
		return list;
	}
	
	
	
}
