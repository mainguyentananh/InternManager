<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Phân Công Giảng Viên</h1>
</div>
<hr>
 
 <c:url value="/giangvien/phanconggv/xacnhan" var="url"/>
 <div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Giảng Viên Đã Được Phân Công</h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Tên Giảng Viên</th>
						<th>Số Lượng Sinh Viên</th>
						<td></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${gvduocphancong}" var="arr">
					<tr class="text-dark">
						<td>${arr[1]}</td>
						<td>${arr[0]}</td>				
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		
 ${param.notify}
 <div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Phân Công Giảng Viên ${tenbomon} </h2>
		<div class="table-responsive text-center">
			<table class="table ">
				<thead>
					<tr class="text-light bg-dark">
						<th>Mã Số SV</th>
						<th>Tên Công Ty</th>
						<th>Địa Chỉ</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${thongtintt}" var="tt">
					<tr class="text-dark">
						<td>${tt.TTTT_sinhVien.maSoSV}</td>
						<td>${tt.donViThucTap.tenDV}</td>
						<td>${tt.donViThucTap.diaChi}</td>
						<td>
			
						<form action="${url}" method="POST" >
								<input type="hidden" value="${tt.TTTT_sinhVien.maSoSV}" name="maSoSV"/>				
								<select name="maSoGV">
									<c:forEach items="${giangVienBM}" var="l">
										<option value="${l.maSoGV}">${l.hoTen}</option>		
									</c:forEach>
								</select>
							<input type="submit" value="Xác Nhận"/>
							</form>
						</td>				
					</tr>
				</c:forEach>
				</tbody>	
			</table>
		</div>
		</div>
</div>		

 