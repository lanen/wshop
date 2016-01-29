<%
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>

 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
 <c:set var="lang" scope="request" value="${requestScope.locale.language}"/> 

 <html lang="${lang}">

     <head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title><c:out value="${requestScope.PAGE_INFORMATION.pageTitle}" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="<c:out value="${requestScope.PAGE_INFORMATION.pageDescription}" />">
		<meta name="author" content="<c:out value="${requestScope.MERCHANT_STORE.storename}"/>">

		<link rel="shortcut icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />

		<!-- mobile settings -->
		<meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">

		<jsp:include page="/pages/shop/templates/mugen/sections/shopLinks.jsp" />
 	</head>
 
 	<body>

	<div id="pageContainer" class="">
		<tiles:insertAttribute name="header" ignore="true"/>

		<tiles:insertAttribute name="navbar" ignore="true"/>

		<tiles:insertAttribute name="body" ignore="true"/>

		<tiles:insertAttribute name="footer" ignore="true"/>
	</div>
	<!-- end container -->
	<jsp:include page="/pages/shop/templates/mugen/sections/jsLinks.jsp" />

 	</body>
 
 </html>
 
