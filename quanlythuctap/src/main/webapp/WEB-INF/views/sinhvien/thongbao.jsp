<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thông Báo</h1>
</div>
<hr>


<c:if test="${notify == 3 }">
	<h3>Đã Điền Form Thực Tập. Xin Liên Hệ Cố Vấn Học Tập</h3>
</c:if>

<c:if test="${notify == 1}">
	<h3>Bạn Không Có Trong Danh Sách Thực Tập</h3>
</c:if>

<c:if test="${notify == 2}">
	<h3>Bạn Chưa Đăng Ký Học Phần Thực Tập Thực Tế</h3>
</c:if>