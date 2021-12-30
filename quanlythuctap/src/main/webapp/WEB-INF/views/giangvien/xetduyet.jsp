<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Xét Duyệt </h1>
</div>
<hr>

<div class="row">
		<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">MSSV</th>
				      <th scope="col">Họ Tên</th>
				      <th scope="col">Mã Lớp HP</th>
				      <th scope="col">Đơn Vị Thực Tập</th>
				      <th scope="col">Xét Duyệt</th> 
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${l_thongtin}" var="l">
				    <tr>
				     	 <td>${l.pk_tttt.maSoSV}</td>
				     	 <td>${l.TTTT_sinhVien.hoTen}</td> 	 
				     	 <td>${l.pk_tttt.maLopHP}</td> 
				     	 <td>${l.donViThucTap.tenDV}</td>
						<td><a href="<c:url value="/giangvien/xetduyet/chitietxetduyet/${l.pk_tttt.maSoSV}"/>" 
						class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
				     </tr>
					</c:forEach>		 
				  </tbody>
			</table>
		</div>
		</div>
</div>