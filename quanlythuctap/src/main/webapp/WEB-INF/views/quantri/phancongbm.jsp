<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Phân Công Bộ Môn</h1>
</div>
<hr>

<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Bộ Môn Đã Được Phân Công</h2>
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
				<c:forEach items="${chitiet}" var="ct">
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



<c:url value="/quantri/xacnhanphancong" var="url"/>
<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Phân Công Bộ Môn</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tên Đơn Vị</th>
						<th>Tỉnh Thành Phố</th>
						<th>Số Lượng Sinh Viên</th>
						<td></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${thongke}" var="tk">
					<tr class="text-dark">
						<td>${tk[2]}</td>
						<td>${tk[1]}</td>
						<td>${tk[0]}</td>
						<td>
							<form action="${url}" method="POST">
								<input type="hidden" value="${tk[2]}" name="tenDV"/>
								<input type="hidden" value="${tk[1]}" name="tinhTP"/>
								<select name="boMon">
									<c:forEach items="${listbomon}" var="l">
										<option value="${l.maBoMon}">${l.tenBoMon}</option>		
									</c:forEach>
								</select>
								<button type="submit" class="btn btn-sm	btn-outline-primary">Phân Công</button>
							</form>
						</td>				
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		

