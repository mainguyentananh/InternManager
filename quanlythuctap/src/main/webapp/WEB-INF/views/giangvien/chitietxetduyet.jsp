<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chi Tiết Xét Duyệt</h1>
</div>
<hr>

<c:set value="${chitiet}" var="ct" />

<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Sinh Viên</h2>
		<div class="table-responsive text-center">
			<table class="table bg-dark text-light">
				<tr>
					<th scope="col">Mã Số: <span>${ct.TTTT_sinhVien.maSoSV}</span>
					</th>
					<th scope="col">Họ Tên: <span>${ct.TTTT_sinhVien.hoTen}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Ngày Sinh: <span><f:formatDate
								pattern="dd-MM-yyyy" value="${ct.TTTT_sinhVien.ngaySinh}" /></span>
					</th>
					<th scope="col">Giới Tính: <c:if
							test="${ct.TTTT_sinhVien.gioiTinh == true}">
							<span>Nam</span>
						</c:if> <c:if test="${ct.TTTT_sinhVien.gioiTinh != true}">
							<span>Nữ</span>
						</c:if>
					</th>
				</tr>
				<tr>
					<th scope="col">Nơi Sinh: <span>${ct.TTTT_sinhVien.noiSinh}</span>
					</th>
					<th scope="col">Email: <span>${ct.TTTT_sinhVien.email}</span>
					</th>

				</tr>
				<tr>
					<th scope="col">Số Điện Thoại: <span>${ct.TTTT_sinhVien.soDienThoai}</span>
					</th>
					<th scope="col">Khóa: <span>${ct.TTTT_sinhVien.khoaHoc.tenKhoaHoc}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Lớp Chuyên Ngành: <span>${ct.TTTT_sinhVien.lopChuyenNganh.maLopCN}</span>
					</th>
					<th scope="col">Ngành: <span>${ct.TTTT_sinhVien.lopChuyenNganh.nganh.tenNganh}</span>
					</th>
				</tr>
			</table>
		</div>
	</div>
</div>

<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Lớp Học Phần</h2>
		<div class="table-responsive text-center">
			<table class="table bg-dark text-white">
				<thead>
					<tr>
						<th>Mã Lớp</th>
						<th>Tên Lớp Học Phần</th>
						<th>Mã Học Phần</th>
						<th>Học Phần</th>
						<th>Học Kỳ</th>
						<th>Năm Học</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ct.lopHocPhan.maLopHP}</td>
						<td>${ct.lopHocPhan.tenLop}</td>
						<td>${ct.lopHocPhan.LHP_hocPhan.maHocPhan}</td>
						<td>${ct.lopHocPhan.LHP_hocPhan.tenHocPhan}</td>
						<td>${ct.lopHocPhan.LHP_hocKy.tenHocKy}</td>
						<td>${ct.lopHocPhan.LHP_namHoc.nienKhoa}</td>
					</tr>
				
				</tbody>
			
			</table>
		</div>
		</div>
</div>		


<div class="row ">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Công Ty Thực Tập</h2>
		<div class="table-responsive text-center">
			<table class="table bg-dark text-light">
				<tr>
					<th scope="col">Đơn Vị Tuyển Dụng: <span>${ct.donViThucTap.tenDV}</span>
					</th>
					<th scope="col">Địa Chỉ: <span>${ct.donViThucTap.diaChi}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Tỉnh/Thành Phố: <span>${ct.donViThucTap.tinhThanhPho} </span>
					</th>
					<th scope="col">Số Điện Thoại: <span>${ct.donViThucTap.soDienThoaiDV}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Email: <span>${ct.donViThucTap.emailDV}</span>
					</th>
					<th scope="col">Hướng Dẫn: <span>${ct.donViThucTap.hoTenNHD}</span>
					</th>

				</tr>
				<tr>
					<th scope="col">Số Điện Thoại NHD: <span>${ct.donViThucTap.soDienThoaiNHD}</span>
					</th>
					<th scope="col">Email NHD: <span>${ct.donViThucTap.emailNHD}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Môi Trường: <span>${ct.donViThucTap.moiTruong}</span>
					</th>
					<th scope="col">Nội Dung Công Việc: <span>${ct.donViThucTap.noiDungCV}</span>
					</th>
				</tr>
				<tr>
					<th scope="col">Số Giờ Thực Tập: <span>${ct.donViThucTap.thoiGianTT}</span>
					</th>
					<th scope="col">Bắt Đầu Thực Tập: <span>
		<f:formatDate pattern="dd-MM-yyyy"
			value="${ct.donViThucTap.batDauThucTap}" /></span>
					</th>
				</tr>
				<tr>
					<th scope="col">Hỗ Trợ: <span>${ct.donViThucTap.hoTro}</span>
					</th>
					<th scope="col">Ghi Chú: <span>${ct.donViThucTap.ghiChu}</span>
					</th>
				</tr>
			</table>
		</div>
	</div>
</div>

<c:if test="${ct.xetDuyet > 1}">
	<c:url value="/giangvien/xetduyet/xacnhanxetduyet" var="url"/>
	<h2 class="text-center text-dark mb-3 mt-2">Xác Nhận Thực Tập</h2>
	<form action="${url}" method="POST" class="mb-3">
	<p>Sinh Viên Có Thể Thực Tập ?</p>
	<input type="hidden" name="mssv" value="${ct.TTTT_sinhVien.maSoSV}"/>
	<div class="col-3">
		<input type="radio" name="quyetDinh" value="0" checked="checked"/><label> Không Thể</label>
	</div>
	<div class="col-3">
		<input type="radio" name="quyetDinh" value="1"/><label> Có Thể</label>
	</div>
	<div class="col mt-2 mb-2">
		Ghi Chú: <input type="text" name="ghiChu" class="col-6"/>
	</div> 
	<div class="form-row">
		<div class="col-md-6 col-sm-12">	
			<button type="submit" class="btn btn-primary btn rounded-0 ">Xác Nhận</button>
		</div>
	</div>
	</form>
</c:if>
