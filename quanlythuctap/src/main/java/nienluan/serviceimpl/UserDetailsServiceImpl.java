package nienluan.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nienluan.dao.giangVienDao;
import nienluan.dao.sinhVienDao;
import nienluan.model.giangVien;
import nienluan.model.sinhVien;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private giangVienDao gvd;
	
	@Autowired
	private sinhVienDao svd;

	@Override
	public UserDetails loadUserByUsername(String email)  {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		try {
			giangVien gv =	gvd.loadGiangVienByEmail(email);
			return new User(gv.getEmail(),gv.getMatKhau(), enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked,gv.getAuthorities());
		} catch (Exception e) {
			sinhVien sv =	svd.loadSinhVienByEmail(email);
			return new User(sv.getEmail(),sv.getMatKhau(), enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked,sv.getAuthorities());
		}
				
		
	}
	
	
}
