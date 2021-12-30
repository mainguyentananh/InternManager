<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<h1 class="h3 mb-0 text-gray-800">Xác Nhận Thực Tập</h1>
</div>
<hr>

<div class="mb-3">
	<a class="btn btn-primary" href='<c:url value="/sinhvien/xacnhantt"/>'>Đơn Vị Tuyển Dụng Thực Tập Từ Trường</a>
	<a class="btn btn-primary" href="<c:url value="/sinhvien/xacnhantt/donvikhac"/>">Đơn Vị Tuyển Dụng Khác</a>
	<a class="btn btn-primary" href="<c:url value="/sinhvien/xacnhantt/donvimoi"/>">Thêm Đơn Vị Tuyển Dụng</a>	
</div>


<h4>Đơn Vị Tuyển Dụng Thực Tập Từ Trường</h4>
<c:url value="/sinhvien/luuxacnhantt" var="url" />
<form action="${url}" method=POST>
	<div class="form-row mb-3">
	<div class="col-md-12 col-sm-12">
	<label class="text-dark">Đơn Vị Thực Tập </label>
	<select name="idTuyenDung"  class="form-control">
		<c:forEach items="${tuyendung}" var="td">
				<optgroup label="${td.tenDV} (${td.tinhThanhPho}): " >
						<option value="${td.maSoTD}">
						 ${td.diaChi}, (<fmt:formatDate pattern="dd-MM-YYYY" value="${td.dauThoiGian}"/>)
						</option>
				</optgroup>		
				
		</c:forEach>
	</select>
	</div>
	<div class="col-md-12 col-sm-12">
			<label class="text-dark">Bắt Đầu Thực Tập <span
				class="text-danger">*</span></label> <input type="date" name="ngayBatDau"
				class="form-control" required />
		</div>
		</div>
	<button type="submit" class="btn btn-sm btn-outline-primary">Xác Nhận</button>
</form>
