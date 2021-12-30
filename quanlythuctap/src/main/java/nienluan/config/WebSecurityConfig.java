package nienluan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import nienluan.serviceimpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl us;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(us);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	//userDetailsService(nv) . khi remove jsession ID mà còn remember-me fix required userdetailsservice
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider()).userDetailsService(us);
	}
		
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new MySimpleUrlAuthenticationSuccessHandler();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/giangvien/xetduyet/**","/giangvien/phanconggv/**").hasAuthority("ROLE_GVC");
		
		http.authorizeRequests().antMatchers("/giangvien/tuyendung","/giangvien/chitiettuyendung/**","/giangvien/themcongty","/giangvien/luucongty")
		.hasAnyAuthority("ROLE_GVC","ROLE_QT","ROLE_GV");
		
		http.authorizeRequests().antMatchers("/quantri/exthemcongty").hasAnyAuthority("ROLE_GVC","ROLE_QT");
		
		
		http.authorizeRequests().antMatchers("/giangvien/**").hasAnyAuthority("ROLE_GV","ROLE_GVC");
		http.authorizeRequests().antMatchers("/sinhvien/**").hasAuthority("ROLE_SV");
		http.authorizeRequests().antMatchers("/quantri/**").hasAuthority("ROLE_QT");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		http.authorizeRequests()
			.and().formLogin().loginPage("/dangnhap")
			.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("email").passwordParameter("password")
				.successHandler(myAuthenticationSuccessHandler())
				.failureUrl("/dangnhap?error=true")
				.and().logout().logoutUrl("/dangxuat").logoutSuccessUrl("/dangnhap").deleteCookies("remember-me");
				
		//Config remember-me		
		http.rememberMe().key("uniqueAndSecret").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400);	
	}

	//Lưu tạm cookies trên ram
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
		 InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); 
	     return memory;
	 }
	
}
