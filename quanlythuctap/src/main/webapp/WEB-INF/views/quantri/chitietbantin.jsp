<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chi Tiết Bản Tin</h1>
</div>

<c:set value="${banTin}" var="bt"/>
<c:url value="/static/fileupload" var="url"/>
<div class="text-dark mb-3">
	<div><span class="font-weight-bold">Tiêu Đề: </span> ${bt.tieuDe}</div>
	<div><span class="font-weight-bold">Tóm Tắt: </span> ${bt.tomTat}</div>
	<div><span class="font-weight-bold">Nội Dung: </span> ${bt.noiDung}</div>
	 
	
	<c:if test="${not empty listFile}">
	<div><span class="font-weight-bold">File Đính Kèm: </span>
	<c:forEach items="${listFile}" var="l">
		<div><a href="${url}/${l}">${l}</a></div>
	</c:forEach>
	</div>
	</c:if>
	
	<div><span class="font-weight-bold">Ngày Đăng: </span><fmt:formatDate pattern = "HH:mm dd-MM-YYYY" 
         value = "${bt.ngayDang}"/></div>
</div>