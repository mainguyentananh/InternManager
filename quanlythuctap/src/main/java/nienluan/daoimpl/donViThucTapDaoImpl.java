package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.donViThucTapDao;
import nienluan.model.donViThucTap;

@Repository
public class donViThucTapDaoImpl implements donViThucTapDao{

	@Autowired
	private SessionFactory	sessionfactory;
	
	@Override
	public List<donViThucTap> getAllDonViThucTap() {
		Session session = sessionfactory.getCurrentSession();
		List<donViThucTap> list = session.createQuery("From donViThucTap",donViThucTap.class).list();
		return list;
	}

	@Override
	public void saveDonViTT(donViThucTap dv) {
		Session session = sessionfactory.getCurrentSession();
		session.save(dv);
		
	}

	@Override
	public donViThucTap getById(String msdv) {
		Session session = sessionfactory.getCurrentSession();
		donViThucTap dv = session.createQuery("From donViThucTap where maSoDVTT =:msdv",donViThucTap.class).setParameter("msdv", msdv).list().get(0);
		return dv;
	}

	
	
	
	
}
