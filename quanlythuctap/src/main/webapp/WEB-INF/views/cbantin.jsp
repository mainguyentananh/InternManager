<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb bg-white text-dark">
		<li class="breadcrumb-item font-weight-bold">Bản Tin</li>
	</ol>
</nav>
<c:set value="${banTin}" var="bt" />
<c:url value="/static/fileupload" var="url" />
<div class="text-dark mb-2 bg-white">
	<div class="ml-3">
	<div>
		<span class="font-weight-bold">Tiêu Đề: </span> ${bt.tieuDe}
	</div>
	<div>
		<span class="font-weight-bold">Nội Dung: </span> ${bt.noiDung}
	</div>


	<c:if test="${not empty listFile}">
		<div>
			<span class="font-weight-bold">File Đính Kèm: </span>
			<c:forEach items="${listFile}" var="l">
				<div class="ml-3">
					<a href="${url}/${l}" download>${l}</a>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<div>
		<span class="font-weight-bold">Ngày Đăng: </span>
		<fmt:formatDate pattern="HH:mm dd-MM-YYYY" value="${bt.ngayDang}" />
	</div>
	</div>
</div>