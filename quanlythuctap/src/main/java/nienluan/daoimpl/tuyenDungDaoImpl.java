package nienluan.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nienluan.dao.tuyenDungDao;
import nienluan.model.tuyenDung;

@Repository
public class tuyenDungDaoImpl implements tuyenDungDao{

	@Autowired
	private SessionFactory	sessionfactory;
	
	@Override
	public List<tuyenDung> getAllTuyenDung() {
		Session session = sessionfactory.getCurrentSession();
		List<tuyenDung> list = session.createQuery("From tuyenDung where check_state=0 order by dauThoiGian desc",tuyenDung.class).list();
		return list;
	}

	@Override
	public List<tuyenDung> getAllTuyenDungHienTai() {
		Session session = sessionfactory.getCurrentSession();
		List<tuyenDung> list = session.createQuery("From tuyenDung where check_state=0 and year(dauthoigian) >= year(curdate()) order by dauThoiGian desc",tuyenDung.class).list();
		return list;
	}
	
	@Override
	public List<tuyenDung> getAllTuyenDungKhac() {
		Session session = sessionfactory.getCurrentSession();
		List<tuyenDung> list = session.createQuery("From tuyenDung where check_state=1 and year(dauthoigian) >= year(curdate()) order by dauThoiGian desc",tuyenDung.class).list();
		return list;
	}
	
	@Override
	public void saveTuyenDung(tuyenDung td) {
		Session session = sessionfactory.getCurrentSession();
		session.save(td);	
	}

	@Override
	public tuyenDung getByID(int MaSoTD) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(tuyenDung.class, MaSoTD);
	}

	@Override
	public void updateTuyenDung(tuyenDung td) {
		Session session = sessionfactory.getCurrentSession();
		session.update(td);	
	}

	
	@Override
	public List<tuyenDung> getTuyenDung(String tenDV, String emailDV, String tinhThanhPho ,String soDienThoaiDV) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From tuyenDung where tenDV like :tenDV and emailDV like :emailDV and tinhThanhPho like :tinhThanhPho and soDienThoaiDV like :soDienThoaiDV order by dauThoiGian desc";
		List<tuyenDung> td = session.createQuery(hql,tuyenDung.class)
				.setParameter("tenDV", tenDV)
				.setParameter("emailDV", emailDV)
				.setParameter("tinhThanhPho", tinhThanhPho)
				.setParameter("soDienThoaiDV", soDienThoaiDV)
				.list();
		return td;
	}
	
	
}
