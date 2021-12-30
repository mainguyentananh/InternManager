<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Giảng Viên</h1>
</div>
<hr>
<div class="row">
	<div class="col">
		<h2 class="text-center text-dark mb-3 mt-2">Thông Tin Giảng Viên</h2>
		<div class="table-responsive text-center">
			<table class="table bg-dark text-light">
				<tr>
					<th scope="col">Mã Số: <span>${info.maSoGV}</span>
					</th>
					<th scope="col">Họ Tên: <span>${info.hoTen}</span>
					</th>

				</tr>
				<tr>
					<th scope="col">Giới Tính: <c:if test="${info.gioiTinh == true}">
							<span>Nam</span>
						</c:if> <c:if test="${info.gioiTinh != true}">
							<span>Nữ</span>
						</c:if>
						</th>
					<th scope="col">Email: <span>${info.email}</span>
					</th>
					
				</tr>
				<tr>
					<th scope="col">Bộ Môn: <span>${info.GV_boMon.tenBoMon}</span>
						</th>
					<th scope="col">Chức Vụ: <span>${info.chucVu}</span>
					</th>
					
				</tr>
			
			</table>
		</div>
	</div>
</div>