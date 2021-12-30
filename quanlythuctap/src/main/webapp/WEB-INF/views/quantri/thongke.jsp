<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thống Kê</h1>
</div>

<c:url value="/quantri/thongke" var="url"/>
 <form action="${url}" method="POST">
	<select name="hocKy">
	
 		<c:forEach items="${hocKy}" var="hk">
 			<c:if test="${param.hocKy != hk.maHocKy }">
 				<option  value="${hk.maHocKy}" >${hk.tenHocKy}</option>
 			</c:if>
 			
 			<c:if test="${param.hocKy == hk.maHocKy }">
 				<option selected="selected" value="${hk.maHocKy}" >${hk.tenHocKy}</option>
 			</c:if>
 		</c:forEach>

 	</select>
 	<select name="namHoc">
 		<c:forEach items="${namHoc}" var="nh">
 		<c:if test="${param.namHoc != nh.maNamHoc }">
 				<option  value="${nh.maNamHoc}" >${nh.nienKhoa}</option>
 			</c:if>
 		
 			<c:if test="${param.namHoc == nh.maNamHoc }">
 				<option selected="selected" value="${nh.maNamHoc}" >${nh.nienKhoa}</option>
 			</c:if>
 		</c:forEach>
 	</select>
	 	
 	<button type="submit" class="btn btn-sm btn-outline-primary">Lọc</button>
 </form>
 
 <c:if test="${not empty tongSV}">
 <div class="row">
 		<div class="col-4"><span class="font-weight-bold">Tổng Sinh Viên: </span> ${tongSV[0]}</div>
		<div class="col-4"><span class="font-weight-bold">Học Kỳ: </span> ${tongSV[2]}</div>
		<div class="col-4"><span class="font-weight-bold">Niên Khóa: </span> ${tongSV[1]}</div>
</div>


<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Bộ Môn Theo Dõi</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tên Bộ Môn</th>
						<th>Số Lượng Sinh Viên</th>
						<td></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${tongSVBM}" var="ct">
					<tr class="text-dark">
						<td>${ct[1]}</td>
						<td>${ct[0]}</td>				
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		


<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Giảng Viên Theo Dõi</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tên Giảng Viên</th>
						<th>Số Lượng Sinh Viên</th>
						<th>Bộ Môn</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${giangVienTheoDoiSV}" var="ct">
					<tr class="text-dark">
						<td>${ct[1]}</td>
						<td>${ct[0]}</td>
						<td>${ct[2]}</td>			
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>	

<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Công Ty Nhân Thực Tập</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tên Công Ty</th>
						<th>Tỉnh/Thành Phố</th>
						<th>Số Lượng Sinh Viên</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${tongSVCT}" var="ct">
					<tr class="text-dark">
						<td>${ct[1]}</td>
						<td>${ct[2]}</td>
						<td>${ct[0]}</td>				
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>

 </c:if>
 
  <div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Danh Sách Sinh Viên Đi Thực Tập </h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Mã Số SV</th>
						<th>Tên </th>
						<th>Công Ty</th>
						<th>Tỉnh/Thành Phố</th>
						<th>Bộ Môn Theo Dõi</th>
						<th>Mã Giáo Viên</th>
						<th>Tên Giáo Viên Theo Dõi</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${thongTinTT}" var="tt">
					<tr class="text-dark">
						<td>${tt.TTTT_sinhVien.maSoSV}</td>
						<td>${tt.TTTT_sinhVien.hoTen}</td>
						<td>${tt.donViThucTap.tenDV}</td>
						<td>${tt.donViThucTap.tinhThanhPho}</td>
						<td>${tt.TTTT_boMon.tenBoMon}</td>	
						<td>${tt.giangVien.maSoGV}</td>	
						<td>${tt.giangVien.hoTen}</td>	
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		

 
 