package nienluan.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import nienluan.service.hocKyService;
import nienluan.service.namHocService;

public class Interceptor implements HandlerInterceptor{

	@Autowired
	private hocKyService hks;
	
	@Autowired
	private namHocService nhs;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("hocKy", hks.getAllHocKy());
		request.setAttribute("namHoc", nhs.getAllNamHoc());		
		return true;
	}

	
	
}
