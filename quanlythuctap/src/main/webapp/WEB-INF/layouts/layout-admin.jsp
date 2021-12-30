<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Quản Lý Thực Tập</title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<link rel="icon"
	href="https://yu.ctu.edu.vn/images/upload/article/2020/03/0305-logo-ctu.png" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/ft/css/all.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/sb-admin-2.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/ft/css/fontawesome.css"/>">
</head>
<body>

	<div id="wrapper">
		<ul
			class="navbar-nav  bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">


			<div class="mt-3">
				<li class="h4 nav-item text-center text-white font-weight-bold">Quản
					Lý Thực Tập</li>
				<div class="mt-3">
					<hr class="sidebar-divider my-0">

					<sec:authorize access="hasRole('ROLE_SV')">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/sinhvien" />"><i
								class="fas fa-info-circle"></i><span>Thông Tin Sinh Viên</span>
						</a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/sinhvien/chitietcv" />"> <i
								class="fas fa-file-upload"></i> <span>Chi Tiết Công Việc</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/sinhvien/xacnhantt" />"> <i
								class="fas fa-clipboard-check"></i> <span>Xác Nhận Thực
									Tập</span></a></li>
					</sec:authorize>

					<sec:authorize access="hasRole('ROLE_GV') or hasRole('ROLE_GVC')">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien" />"><i
								class="fas fa-info-circle"></i><span>Thông Tin Giảng Viên</span>
						</a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/giangday" />"> <i
								class="fas fa-chalkboard-teacher"></i> <span>Giảng Dạy</span></a></li>
								
							<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/diemso" />"> <i class="fas fa-book"></i>
							 <span>Điểm Số</span></a></li>
					</sec:authorize>
					
			



					<sec:authorize access="hasRole('ROLE_GVC')">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/xetduyet" />"> <i
								class="fas fa-user-check"></i> <span>Xét Duyệt</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/danhsachxetduyet" />"> <i class="fas fa-users"></i>
							 <span>Danh Sách Xét Duyệt</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/phanconggv" />"> <i class="fas fa-user-plus"></i>
							 <span>Phân Công Giảng Viên</span></a></li>
					</sec:authorize>
					

					<sec:authorize access="hasRole('ROLE_QT')">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri" />"><i
								class="fas fa-info-circle"></i><span>Thông Tin Quản Trị</span> </a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri/phancongbm" />"> <i
								class="fas fa-user-plus"></i> <span>Phân Công Bộ Môn</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri/danhsachphancong" />"> <i class="fas fa-users"></i>
							 <span>Danh Sách Phân Công</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri/thongke" />"> <i
								class="fas fa-chart-bar"></i> <span>Thống Kê</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri/ketqua" />"> <i
								class="fas fa-book"></i> <span>Kết Quả</span></a></li>
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/quantri/bantin" />"> <i
								class="fas fa-newspaper"></i> <span>Bản Tin</span></a></li>
						

					</sec:authorize>
					
					<sec:authorize access="hasRole('ROLE_GV') or hasRole('ROLE_GVC') or hasRole('ROLE_QT')">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value="/giangvien/tuyendung" />"><i class="fas fa-building"></i>
							<span>Nhà Tuyển Dụng</span>
								</a></li>
					</sec:authorize>
					<hr class="sidebar-divider my-0" />
					<li class="nav-item "><a class="nav-link"
						href="<c:url value="/trangchu" />"> <i class="fas fa-home"></i>
							<span>Trang Chủ</span>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="<c:url value="/dangxuat" />"> <i
							class="fas fa-sign-out-alt"></i> <span>Đăng Xuất</span>
					</a></li>


				</div>
		</ul>

		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><span
							class="mr-2 d-none d-lg-inline text-gray-600 small">${pageContext.request.userPrincipal.name}</span>
						</li>
					</ul>
				</nav>
				<div class="container">
					<tiles:insertAttribute name="content" />

				</div>
			</div>
		</div>
		<script type="text/javascript"
			src="<c:url value="/static/js/jquery-3.5.1.js" />"></script>
</body>
</html>

