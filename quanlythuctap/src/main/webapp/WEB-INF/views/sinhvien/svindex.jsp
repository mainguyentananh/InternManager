<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Quản Lý Thực Tập</h1>
</div>
<hr>
<c:set value="${thongTinSV}" var="sv" />
<c:set value="${thongTinTT}" var="tt" />

<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Sinh Viên</h2>
		<div class="table-responsive text-center">
			<table class="table bg-dark text-light">
				<tr>
					<th scope="col">Mã Số: <span>${sv.maSoSV}</span>
					</th>
					<th scope="col">Họ Tên: <span>${sv.hoTen}</span>
					</th>

				</tr>
				<tr>
				
					<th scope="col">Ngày Sinh: <span><f:formatDate pattern = "dd-MM-yyyy"  value="${sv.ngaySinh}"/></span>
					</th>
					<th scope="col">Giới Tính: <c:if test="${sv.gioiTinh == true}">
							<span>Nam</span>
						</c:if> <c:if test="${sv.gioiTinh != true}">
							<span>Nữ</span>
						</c:if>

					</th>
				</tr>
				<tr>
					<th scope="col">Nơi Sinh: <span>${sv.noiSinh}</span>
					</th>
					<th scope="col">Email: <span>${sv.email}</span>
					</th>

				</tr>
				<tr>
					<th scope="col">Số Điện Thoại: <span>${sv.soDienThoai}</span>
					</th>
					<th scope="col">Khóa: <span>${sv.khoaHoc.tenKhoaHoc}</span>
					</th>
				</tr>

				<tr>
					<th scope="col">Lớp Chuyên Ngành: <span>${sv.lopChuyenNganh.maLopCN}</span>
					</th>
					<th scope="col">Ngành: <span>${sv.lopChuyenNganh.nganh.tenNganh}</span>
					</th>
				</tr> 
			</table>
		</div>
	</div>
</div>

<div>Số Điện Thoại Phải Chính Xác. Để Giáo Viên Có Thể Liên Hệ.</div>
<c:url value="/sinhvien/capnhatsdt" var="url" />
<div>Cập Nhật Lại Số Điện Thoại <a href="${url}">Tại Đây</a></div>


<div class="row">
		<div class="col ">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Thực Tập</h2>
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Mã Lớp HP</th>
				      <th scope="col">Chi Tiết Công Việc</th>
				      <th scope="col">Tên Giảng Viên</th>
				      <th scope="col">Email Giảng Viên</th>
				      <th scope="col">Số Điện Thoại Giảng Viên</th>
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				   
				    <tr>
				   		<td>${tt.lopHocPhan.maLopHP}</td>
				   		
				   		<c:if test="${not empty tt.congViec }">
					    	<c:url value="/static/${tt.congViec}" var="chitietcv"/>
					   		<td><a href="${chitietcv}" target="_blank">Xem</a></td>
				   		</c:if>
				   		<c:if test="${empty tt.congViec}">
				   			<td>Chưa upload công việc</td>
				   		</c:if>
				   		
				   		<td>${tt.giangVien.hoTen}</td>
				   		<td>${tt.giangVien.email}</td>
				   		<td>${tt.giangVien.soDienThoai}</td>
				     </tr>	 
				  </tbody>
			</table>
		</div>
		</div>
</div>