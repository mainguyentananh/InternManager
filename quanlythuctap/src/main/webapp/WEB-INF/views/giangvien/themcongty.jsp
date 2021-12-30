<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thêm Công Ty Thực Tập</h1>
</div>
<hr>

<c:url value="/giangvien/luucongty" var="save" />
<form:form action="${save}" modelAttribute="n_donvi" class="mb-3">
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Tên Công Ty </label>
			<form:input path="tenDV" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Địa Chỉ Công Ty </label>
			<form:input path="diaChi" class="form-control" required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Điện Thoại Công Ty </label>
			<form:input path="soDienThoaiDV" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Email Công Ty </label>
			<form:input path="emailDV" type="email" class="form-control"
				required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Công Ty Thuộc Tỉnh/Thành Phố </label>
			<form:input path="tinhThanhPho" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Họ Tên Người Hướng Dẫn </label>
			<form:input path="hoTenNHD" class="form-control" required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Điện Thoại Người Hướng Dẫn </label>
			<form:input path="soDienThoaiNHD" class="form-control"
				required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Email Người Hướng Dẫn </label>
			<form:input path="emailNHD" type="email" class="form-control"
				required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Môi Trường Làm Việc </label>
			<form:input path="moiTruong" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Địa Chỉ Web </label>
			<form:input path="diaChiWeb" class="form-control"/>
		</div>
	</div>
	
<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Giờ Thực Tập</label>
			<form:input path="thoiGianTT" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Lượng Nhận Sinh Viên</label>
			<form:input path="soLuongNhanSV" class="form-control" required="true"/>
		</div>
	</div>
	
		<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Ghi Chú</label>
			<form:input path="ghiChu" class="form-control" />
		</div>	
		
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Dấu Thời Gian</label> <input type="date" name="dauTG"
				class="form-control" required />
		</div>
			
	</div>
		<div class="form-row mb-3">
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Yêu Cầu</label>
			<form:textarea path="yeuCau" class="col" rows="10" required="true"/>
		</div>
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Nội Dung Công Việc Sẽ Làm </label>
			<form:textarea path="noiDungCV" class="col" rows="10" required="true"/>
		</div>
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Quyền Lợi</label>
			<form:textarea path="quyenLoi" class="col" rows="10"/>
		</div>
	</div>
	

	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<button type="submit" class="btn btn-primary btn rounded-0 ">Thêm Công Ty</button>
		</div>
	</div>
</form:form>
