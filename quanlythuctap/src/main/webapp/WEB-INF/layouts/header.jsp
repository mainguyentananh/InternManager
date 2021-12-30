<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="mb-1">
	<img src="http://www.cit.ctu.edu.vn/images/cit/logo-khoa-55namctu.png" width="100%" height="auto"/>

</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white ">
	
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			
			<ul class="navbar-nav mr-auto nav ">
				<li class="nav-item active"><a class="nav-link"
					href='<c:url value="/trangchu"/>'>Trang Chủ</a></li>
				<li class="nav-item "><a class="nav-link"
					href='<c:url value="/donvi"/>'>Đơn Vị Thực Tập</a></li>


				<li class="nav-item"><sec:authorize access="!isAuthenticated()">
						<a class="nav-link" href="<c:url value="/dangnhap"/>">Đăng
							Nhập</a>
					</sec:authorize> <sec:authorize access="isAuthenticated()">
						<li class="nav-item">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle " id="navbarDropdownMenuLink"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								${pageContext.request.userPrincipal.name} </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">

								<sec:authorize access="hasRole('ROLE_SV')">
									<a class="dropdown-item" href="<c:url value="/sinhvien"/>">Hệ
										Thống</a>

								</sec:authorize>
								<sec:authorize
									access="hasRole('ROLE_GV') or hasRole('ROLE_GVC')">
									<a class="dropdown-item" href="<c:url value="/giangvien"/>">Hệ
										Thống</a>

								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_QT')">
									<a class="dropdown-item" href="<c:url value="/quantri"/>">Hệ
										Thống</a>

								</sec:authorize>

								<a class="dropdown-item" href="<c:url value="/dangxuat"/>">Đăng
									Xuất</a>
							</div></li></li>
				</sec:authorize>

				</li>
			</ul>
		</div>
		
</nav>

