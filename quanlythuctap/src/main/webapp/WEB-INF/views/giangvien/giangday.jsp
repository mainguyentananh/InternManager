<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Giảng Dạy Được Phân Công</h1>
</div>
<hr>

<c:url value="/giangvien/giangday" var="url"/>
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
 
 
<div class="row">
		<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">MSSV</th>
				      <th scope="col">Họ Tên</th>
				      <th scope="col">Tên Đơn Vị</th>
				      <th scope="col">Tỉnh Thành Phố</th>
				      <th scope="col">Chi Tiết</th>
					  <th scope="col">Phiếu Theo Dõi</th>
					 
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				  
				    <c:forEach items="${l_thongtin}" var="l">
				    
				    <tr>
				     	 <td>${l.pk_tttt.maSoSV}</td>
				     	 <td>${l.TTTT_sinhVien.hoTen}</td> 	 
				     	 <td>${l.donViThucTap.tenDV }</td>
				     	 <td>${l.donViThucTap.tinhThanhPho}</td>
						<td><a target="_blank" href="<c:url value="/giangvien/giangday/chitietsinhvien/${l.pk_tttt.maSoSV}"/>" 
						class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
						<c:if test="${not empty l.congViec }">
						    <c:url value="/static/${l.congViec}" var="chitietcv"/>
					   		<td><a href="${chitietcv}" target="_blank">Xem</a></td>
					    </c:if>	
					    
					    <c:if test="${empty l.congViec }">
					    	<td>Sinh Viên Chưa Upload</td>
					    </c:if>
						
				     </tr>
					</c:forEach>		 
				  </tbody>
			</table>
		</div>
		</div>
</div>