<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item font-weight-bold"> Trang Chủ</li>
			  </ol>
	</nav>
<c:forEach items="${l_banTin}" var="l">
<div class="card mb-2" >
  <div class="row no-gutters">
    <div class="col-md-4">
    <a href="<c:url value="/bantin/${l.id}"/>">
      <img src="https://vase.com.vn/wp-content/uploads/icon-thong-bao.png" class="card-img"  width="auto" height="230px">
      </a>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title font-weight-bold">${l.tieuDe}</h5>
        <p class="card-text">${l.tomTat}</p>
        <p class="card-text"><a href="<c:url value="/bantin/${l.id}"/>">Xem Thêm</a></p>
        <p class="card-text"><small class="text-muted"><fmt:formatDate pattern = "HH:mm dd-MM-YYYY" 
         value = "${l.ngayDang}"/></small></p>
      </div>
    </div>
  </div>
</div>
</c:forEach>