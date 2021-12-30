<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Đăng Nhập</title>
<link rel="icon" href="https://yu.ctu.edu.vn/images/upload/article/2020/03/0305-logo-ctu.png" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/sb-admin-2.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/ft/css/all.css"/>">
<body class="bg-gradient-primary">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-8 ">
				<div class="card card-space-s" >
					<div class="card-body">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Vui Lòng Đăng Nhập!</h1>
									</div>
									<form class="user"
										action="<c:url value='j_spring_security_check' />"
										method='POST'>
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name='email' placeholder="Email">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												name='password' placeholder="Password">
										</div>			
										${message}
										<hr>
										<div class="mb-3"> <input type="checkbox" name="remember-me" /> Nhớ Mật Khẩu</div>
										<button class="btn btn-primary btn-user btn-block"
											type="submit">Đăng Nhập</button>
										<a href="<c:url value="/trangchu"/>"><i class="fas fa-arrow-left mt-3"></i> Trở Về Trang Chủ</a>	
										
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="<c:url value="/static/js/jquery-3.5.1.js" />"></script>	

</body>
</html>