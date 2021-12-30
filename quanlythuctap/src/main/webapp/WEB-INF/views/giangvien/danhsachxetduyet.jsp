<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Danh Sách Xét Duyệt</h1>
</div>
<hr>

<c:url value="/giangvien/danhsachxetduyet" var="url" />
<form action="${url}" method=POST>
	<select name="hocKy">

		<c:forEach items="${hocKy}" var="hk">
			<c:if test="${param.hocKy != hk.maHocKy }">
				<option value="${hk.maHocKy}">${hk.tenHocKy}</option>
			</c:if>

			<c:if test="${param.hocKy == hk.maHocKy }">
				<option selected="selected" value="${hk.maHocKy}">${hk.tenHocKy}</option>
			</c:if>
		</c:forEach>

	</select> <select name="namHoc">
		<c:forEach items="${namHoc}" var="nh">
			<c:if test="${param.namHoc != nh.maNamHoc }">
				<option value="${nh.maNamHoc}">${nh.nienKhoa}</option>
			</c:if>

			<c:if test="${param.namHoc == nh.maNamHoc }">
				<option selected="selected" value="${nh.maNamHoc}">${nh.nienKhoa}</option>
			</c:if>
		</c:forEach>
	</select> <select name="xetDuyet">
		<c:if test="${param.xetDuyet != 0 and param.xetDuyet !=1}">
			<option value="-1" selected="selected"></option>
			<option value="1">Được Xét Duyệt</option>
			<option value="0">Không Được Xét Duyệt</option>
		</c:if>

		<c:if test="${param.xetDuyet == 1}">
			<option value="-1"></option>
			<option value="1" selected="selected">Được Xét Duyệt</option>
			<option value="0">Không Được Xét Duyệt</option>
		</c:if>
		<c:if test="${param.xetDuyet ==	0}">
			<option value="-1"></option>
			<option value="1">Được Xét Duyệt</option>
			<option value="0" selected="selected">Không Được Xét Duyệt</option>
		</c:if>

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
						<th scope="col">Mã Lớp HP</th>
						<th scope="col">Đơn Vị Thực Tập</th>
						<th scope="col">Xét Duyệt</th>
						<th scope="col">Ghi Chú</th>
						<th scope="col">Chi Tiết</th>
					</tr>
				</thead>
				<tbody class="text-dark">
					<c:forEach items="${l_thongtin}" var="l">
						<tr>
							<td>${l.pk_tttt.maSoSV}</td>
							<td>${l.TTTT_sinhVien.hoTen}</td>
							<td>${l.pk_tttt.maLopHP}</td>
							<td>${l.donViThucTap.tenDV}</td>
							<c:if test="${l.xetDuyet == 0}">
								<td>Không Được Xét Duyệt</td>
							</c:if>
							<c:if test="${l.xetDuyet == 1}">
								<td>Được Xét Duyệt</td>
							</c:if>
							<c:if test="${l.xetDuyet == 2}">
								<td>Chờ Xét Duyệt</td>
							</c:if>
							<td>${l.ghiChu}</td>
							<td><a target="_blank"
								href="<c:url value="/giangvien/xetduyet/chitietxetduyet/${l.pk_tttt.maSoSV}"/>"
								class="btn btn-outline-dark btn-sm"><i class="fas fa-edit"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>