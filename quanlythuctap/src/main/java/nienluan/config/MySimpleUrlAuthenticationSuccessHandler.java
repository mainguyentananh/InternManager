package nienluan.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	 private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			handle(request, response, authentication);
	        clearAuthenticationAttributes(request);
	}

	private void clearAuthenticationAttributes(HttpServletRequest request) {
		 HttpSession session = request.getSession(false);
		    if (session == null) {
		        return;
		    }
		    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		 String targetUrl = determineTargetUrl(authentication); 
		    redirectStrategy.sendRedirect(request, response, targetUrl);
		
	}

	private String determineTargetUrl(Authentication authentication) {
		 Map<String, String> roleTargetUrlMap = new HashMap<>();
		 
		 roleTargetUrlMap.put("ROLE_SV", "/sinhvien");
		 roleTargetUrlMap.put("ROLE_GV", "/giangvien");		 
		 roleTargetUrlMap.put("ROLE_GVC", "/giangvien");
		 roleTargetUrlMap.put("ROLE_QT", "/quantri");
		
		 final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		    for (final GrantedAuthority grantedAuthority : authorities) {
		        String authorityName = grantedAuthority.getAuthority();
		        if(roleTargetUrlMap.containsKey(authorityName)) {
		            return roleTargetUrlMap.get(authorityName);
		        }
		    }
		    throw new IllegalStateException();
	}

	
	
}
