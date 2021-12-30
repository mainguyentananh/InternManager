<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thêm Bản Tin</h1>
</div>

<div class="row mb-2">
	<div class="col">
		<c:url value="/quantri/thembantin" var="save" />
		<form:form action="${save}" enctype="multipart/form-data"
			modelAttribute="n_banTin">
			<label class="font-weight-bold">Tiêu Đề</label>
			<form:input path="tieuDe" required="required" class="form-control" />
			<br>
			<label class="font-weight-bold">Tóm Tắt</label>
			<form:input path="tomTat" required="required" class="form-control" />
			<br>
			<label class="font-weight-bold">Nội Dung</label>
			<form:textarea path="noiDung" required="required" class="col" rows="10"/>
			<label class="font-weight-bold">Chọn File</label>
			<br>
			<input type="file" name="file_u" multiple>
			<br>
			<button type="submit" class="btn btn-outline-primary mt-2 mb-3">Đăng
				Tin</button>
		</form:form>
	</div>
</div>