<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item font-weight-bold"> Đơn Vị Thực Tập</li>
			  </ol>
	</nav>

<div class="text-dark bg-white mb-2">
	<div class="ml-3">
	<div><span class="font-weight-bold">Đơn Vị Tuyển Dụng: </span> ${dv.tenDV}</div>
	<div><span class="font-weight-bold">Địa Chỉ: </span> ${dv.diaChi}</div>
	<div><span class="font-weight-bold">Tỉnh/Thành Phố: </span>${dv.tinhThanhPho}</div>
	<div><span class="font-weight-bold">Số Điện Thoại: </span>${dv.soDienThoaiDV}</div>
	<div><span class="font-weight-bold">Email: </span><a href="mailto:${dv.emailDV}" >${dv.emailDV}</a></div>
	<div><span class="font-weight-bold">Web: </span><a href="${dv.diaChiWeb}" target="_blank">${dv.diaChiWeb}</a></div>
	<div><span class="font-weight-bold">Hướng Dẫn: </span>${dv.hoTenNHD}</div>
	<div><span class="font-weight-bold">Số Điện Thoại: </span>${dv.soDienThoaiNHD}</div>
	<div><span class="font-weight-bold">Email: </span><a href="mailto:${dv.emailNHD}" >${dv.emailNHD}</a></div>
	<div><span class="font-weight-bold">Môi Trường: </span>${dv.moiTruong}</div>
	<div><span class="font-weight-bold">Nội Dung Công Việc: </span>${dv.noiDungCV}</div>
	<div><span class="font-weight-bold">Số Giờ Thực Tập: </span>${dv.thoiGianTT}</div>
	<div><span class="font-weight-bold">Số Lượng Nhận Sinh Viên: </span>${dv.soLuongNhanSV}</div>
	<div><span class="font-weight-bold">Yêu Cầu: </span>${dv.yeuCau}</div>
	<div><span class="font-weight-bold">Quyền Lợi: </span>${dv.quyenLoi}</div>
	<div><span class="font-weight-bold">Ghi Chú: </span>${dv.ghiChu}</div>
	<div><span class="font-weight-bold">Trạng Thái: </span>${dv.trangThai}</div>
	<div><span class="font-weight-bold">Dấu Thời Gian: </span><f:formatDate pattern = "dd-MM-yyyy"  value="${dv.dauThoiGian}"/></div>
	</div>
</div>