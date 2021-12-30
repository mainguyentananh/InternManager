<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Xác Nhận Thực Tập</h1>
</div>
<hr>

<div class="mb-3">
	<a class="btn btn-primary" href='<c:url value="/sinhvien/xacnhantt"/>'>Đơn Vị Tuyển Dụng Thực Tập Từ Trường</a>
	<a class="btn btn-primary" href="<c:url value="/sinhvien/xacnhantt/donvikhac"/>">Đơn Vị Tuyển Dụng Khác</a>
	<a class="btn btn-primary" href="<c:url value="/sinhvien/xacnhantt/donvimoi"/>">Thêm Đơn Vị Tuyển Dụng</a>	
</div>

<h4>Thêm Đơn Vị Tuyển Dụng Thực Tập</h4>

<c:url value="/sinhvien/luuxacnhantt/donvimoi" var="save" />
<form:form action="${save}" modelAttribute="donvi" class="mb-3">
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Tên Công Ty <span
				class="text-danger">*</span></label>
			<form:input path="tenDV" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Địa Chỉ Công Ty <span
				class="text-danger">*</span></label>
			<form:input path="diaChi" class="form-control" required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Điện Thoại Công Ty <span
				class="text-danger">*</span></label>
			<form:input path="soDienThoaiDV" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Email Công Ty <span
				class="text-danger">*</span></label>
			<form:input path="emailDV" type="email" class="form-control"
				required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Công Ty Thuộc Tỉnh/Thành Phố <span
				class="text-danger">*</span></label>
			<form:input path="tinhThanhPho" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Họ Tên Người Hướng Dẫn <span
				class="text-danger">*</span></label>
			<form:input path="hoTenNHD" class="form-control" required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Điện Thoại Người Hướng Dẫn <span
				class="text-danger">*</span></label>
			<form:input path="soDienThoaiNHD" class="form-control"
				required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Email Người Hướng Dẫn <span
				class="text-danger">*</span></label>
			<form:input path="emailNHD" type="email" class="form-control"
				required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Môi Trường Làm Việc <span
				class="text-danger">*</span></label>
			<form:input path="moiTruong" class="form-control"
				placeholder="Có Phòng Làm Việc, Có Máy Tính ,.." required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Nội Dung Công Việc Sẽ Làm <span
				class="text-danger">*</span></label>
			<form:input path="noiDungCV" class="form-control"
				placeholder="BackEnd, FontEnd ,.." required="true" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Số Giờ Thực Tập (1 tuần >=24) <span
				class="text-danger">*</span></label>
			<form:input path="thoiGianTT" class="form-control" required="true" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Hỗ Trợ</label>
			<form:input path="hoTro" class="form-control" />
		</div>
	</div>
	<div class="form-row mb-3">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Ghi Chú</label>
			<form:input path="ghiChu" class="form-control" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Bắt Đầu Thực Tập <span
				class="text-danger">*</span></label> <input type="date" name="ngayBatDau"
				class="form-control" required />
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<button type="submit" class="btn btn-primary btn rounded-0 ">Xác
				Nhận</button>
		</div>
	</div>
</form:form>