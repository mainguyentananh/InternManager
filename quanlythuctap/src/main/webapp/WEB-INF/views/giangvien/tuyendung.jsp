<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Đơn Vị Thực Tập</h1>
</div>


<sec:authorize access="hasRole('ROLE_QT') or hasRole('ROLE_GVC')">
<div class="row mb-2 ">
		<div class="col">
			<c:url value="/quantri/exthemcongty" var="save"/>
				<form action="${save}" method="POST" enctype="multipart/form-data">
					<h5 class="text-dark">Thêm Đơn Vị Thực Tập File Excel</h5>
					<input class="btn btn-secondary" type="file" name="file_u" > <br/>
					<input class="btn btn-primary btn rounded-0 mt-2" type="submit" value="Submit">
				</form>
		</div>
	</div>
	<hr/>
	</sec:authorize>

<div class="row mb-2">
		<div class="col">
				<a class="btn btn-primary btn rounded-0"
					href="<c:url value="/giangvien/themcongty" />">Thêm Đơn Vị Thực Tập</a>
		</div>	
	</div>
	<div class="col">
				${param.notify}
		</div>
	
	<div class="row">
		<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Tên Đơn Vị</th>
				      <th scope="col">Địa Chỉ</th>
				      <th scope="col">Email </th>
				       <th scope="col">Xem Chi Tiết</th> 
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${l_tuyendung}" var="l">
				    <tr>
				     	 <td>${l.tenDV}</td>
				     	 <td>${l.diaChi}</td>
				     	 <td>${l.emailDV}</td>
				     	 <td><a href="<c:url value="/giangvien/chitiettuyendung/${l.maSoTD}"/>" class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
				     </tr>
					</c:forEach>
				    
				 
				  </tbody>
			</table>
		</div>
		</div>
		</div>