<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Danh Sách Phân Công</h1>
</div>
<hr>

<c:url value="/quantri/danhsachphancong" var="url" />
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
	</select>
	<button type="submit" class="btn btn-sm btn-outline-primary">Lọc</button>
</form>


<div class="row">
	<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Công Ty</th>
						<th scope="col">Tỉnh</th>
						<th scope="col">Sinh Viên</th>
						<th scope="col">Bộ Môn</th>
						<th scope="col"></th>
					</tr>
				</thead>			
				<tbody class="text-dark">
					<c:forEach items="${l_thongtin}" var="l">				
						<tr>
							<td>${l[1]}</td>
							<td>${l[2]}</td>
							<td>${l[0]}</td>
							<c:if test="${not empty l[4]}">
								<td>${l[3]}</td>
							</c:if>
							<c:if test="${empty l[4]}">	
							<td>
								<c:url value="/quantri/xnphancong" var="url2" />
								<form action="${url2}" method="POST">
								<input type="hidden" name="tenDV" value="${l[1]}"/>
								<input type="hidden" name="tinhTP" value="${l[2]}"/>
								<input type="hidden" name="namHoc" value="${param.namHoc}" />
								<input type="hidden" name="hocKy" value="${param.hocKy}">
								<select name="boMon">
									<c:forEach items="${l_bomon}" var="bm">
										<c:if test="${l[5] == bm.maBoMon }">
											<option selected="selected" value="${bm.maBoMon}">${bm.tenBoMon}</option>
										</c:if>
										<c:if test="${l[5] != bm.maBoMon }">
											<option value="${bm.maBoMon}">${bm.tenBoMon}</option>
										</c:if>
									</c:forEach>						
								</select>
								<input class="btn btn-primary ml-3" type="submit" value="Chỉnh Sửa"/>
								</form>
							</td>
							
							
							</c:if>
							
						</tr>
					</c:forEach>		
				</tbody>
			</table>
		</div>
	</div>
</div>
