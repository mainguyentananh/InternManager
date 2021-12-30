<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chi Tiết Công Việc</h1>
</div>
<hr />

<c:url value="/sinhvien/upload" var="save" />
	<div>
		<form action="${save}" method="POST" enctype="multipart/form-data">
			<h5>Chi Tiết Công Việc Thực Tập</h5>
			<input type="file" name="file_u"><br>
			<button type="submit" class="btn btn-sm btn-outline-primary mt-2"  >UpLoad</button>
		</form>
	</div>
${notify}
