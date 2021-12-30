<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Danh Sách Điểm Số Giáo Viên Quản Lý</h1>
</div>
<hr>

<c:url value="/giangvien/diemso" var="url"/>
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
 
  <c:if test="${c_xuatFile > 0 }">
 <c:url value="/giangvien/xuatfile" var="url2"/>
 <form action="${url2}" method="POST" >
	<input type="hidden" value="${param.namHoc}" name="namHoc">
	<input type="hidden" value="${param.hocKy}" name="hocKy">
 	<button type="submit" class="btn btn-sm btn-outline-primary">Xuất File Excel</button>
 </form>
 </c:if>
  ${notify}
<div class="row">
		<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">MSSV</th>
				      <th scope="col">Họ Tên</th>
				      <th scope="col">Phái</th>
					  <th scope="col">Mã Môn Học</th>
					  <th scope="col">Điểm</th>
					  <th scope="col">Ghi Chú</th>
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${list_d}" var="l">
				    <tr>
				     	 <td>${l.diem_sinhVien.maSoSV }</td>
				     	 <td>${l.diem_sinhVien.hoTen }</td>		     	 
				     	 <c:if test="${l.diem_sinhVien.gioiTinh == true}">
				     	 	<td>Nam</td>
				     	 </c:if>
				     	 <c:if test="${l.diem_sinhVien.gioiTinh == false}">
				     	 	<td>Nữ</td>
				     	 </c:if>
				     	 <td>${l.hocPhan.maHocPhan }</td>
				     	 <td>${l.diem }</td>
				     	 <td>${l.ghiChu }</td>
					
				     </tr>
					 </c:forEach>
				  </tbody>
			</table>
		</div>
		</div>
</div>