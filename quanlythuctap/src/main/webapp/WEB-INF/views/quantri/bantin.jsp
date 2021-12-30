<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Bản Tin</h1>
</div>
<div class="row mb-2">
		<div class="col">
				<a class="btn btn-primary btn rounded-0"
					href="<c:url value="/quantri/thembantin" />">Thêm Bản Tin</a>
		</div>
	</div>
<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Bản Tin</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tiêu Đề</th>
						<th>Tóm Tắt</th>
						<th>Ngày Đăng</th>
						<th>Xem</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${l_bantin}" var="l">
					<tr class="text-dark">
						<td>${l.tieuDe}</td>
						<td>${l.tomTat}</td>	
						<td><fmt:formatDate pattern = "HH:mm dd-MM-YYYY" 
         value = "${l.ngayDang}"/></td>		
         				<td><a href="<c:url value="/quantri/chitietbantin/${l.id}"/>" class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>	
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		
