<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Cập Nhật Số Điện Thoại</h1>
</div>
<hr>

<c:url value="/sinhvien/kiemtracapnhat" var="url"/>
<form action="${url}" method="POST">
	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Điện Thoại</label>
			<input type="text" name="nsoDienThoai" class="form-control" required/>
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Nhập Mật Khẩu</label>
			<input type="password" name="cpassword" class="form-control" required/>
		</div>
	</div>
	
	<div class="form-row mt-3">
	<div class="col-md-6 col-sm-12">
		<button type="submit" class="btn btn-primary btn rounded-0 ">Cập Nhật</button>
	</div>
	${message}
	</div>
	
</form>