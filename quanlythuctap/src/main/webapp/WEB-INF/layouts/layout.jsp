<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon"
	href="https://yu.ctu.edu.vn/images/upload/article/2020/03/0305-logo-ctu.png" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style-3.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/jquery-ui.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/ft/css/all.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/ft/css/fontawesome.css"/>" />

	<title>Trang Chủ</title>
	
</head>
<body style="background-color: #B0C4DE">
		
	
	
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />
		
	</div>
		<script type="text/javascript" src="<c:url value="/static/js/jquery-3.5.1.js" />"></script>
        <script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js" />"></script>
    
        
</body>
</html>