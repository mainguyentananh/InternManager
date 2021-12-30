<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item font-weight-bold"> Đơn Vị Thực Tập</li>
			  </ol>
	</nav>
<c:forEach items="${l_donVi}" var="l">
<div class="card mb-2" >
  <div class="row no-gutters">
    <div class="col-md-4">
    <a href="<c:url value="/donvi/${l.maSoTD}"/>">
      <img src="http://www.fbb.hcmus.edu.vn/vnt_upload/career/05_2018/icon_web-12.jpg" class="card-img"  width="auto" height="230px">
      </a>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title font-weight-bold">${l.tenDV}</h5>
        <p class="card-text">${l.noiDungCV}</p>
          <p class="card-text">${l.tinhThanhPho}</p>
        <p class="card-text"><a href="<c:url value="/donvi/${l.maSoTD}"/>">Xem Thêm</a></p>
        <p class="card-text"><small class="text-muted"><fmt:formatDate pattern = "dd-MM-YYYY" 
         value = "${l.dauThoiGian}"/></small></p>
      </div>
    </div>
  </div>
</div>
</c:forEach>