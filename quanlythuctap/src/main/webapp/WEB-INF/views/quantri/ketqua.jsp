<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Kết Quả</h1>
</div>

<c:url value="/quantri/ketqua" var="url"/>
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
	 
	 <input type="text" name="hocPhan" required="required" value="${param.hocPhan}" placeholder="Mã Học Phần"/>
	 
 	<button type="submit" class="btn btn-sm btn-outline-primary">Lọc</button>
 </form>
 
 <c:if test="${c_xuatfile > 0 }">
 <c:url value="/quantri/xuatfile" var="url2"/>
 <form action="${url2}" method="POST">
	<input type="hidden" value="${param.namHoc}" name="namHoc">
	<input type="hidden" value="${param.hocKy}" name="hocKy">
	<input type="hidden" value="${param.hocPhan}" name="hocPhan">
 	<button type="submit" class="btn btn-sm btn-outline-primary">Xuất File Excel</button>
 </form>
 </c:if>
 
 ${notify}
  <div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Kết Quả</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Mã Số SV</th>
						<th>Tên</th>
						<th>Học Phần</th>
						<th>Học Kỳ</th>
						<th>Năm Học</th>
						<th>Điểm Số</th>
						<th>Ghi Chú</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${l_diem}" var="l">
					<tr class="text-dark">
						<td>${l.diem_sinhVien.maSoSV}</td>	
						<td>${l.diem_sinhVien.hoTen}</td>
						<td>${l.hocPhan.tenHocPhan}</td>
						<td>${l.hocKy.tenHocKy}</td>
						<td>${l.namHoc.nienKhoa}</td>
						<td>${l.diem}</td>
						<td>${l.ghiChu}</td>
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		

 
 