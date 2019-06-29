<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session ="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>home.jsp</h2>
	<hr>
	<div>message : ${messeage}</div>
	<c:if test="${pageContext.request.userPrincipal.name != null }">
		welcome ${pageContext.request.userPrincipal.name }!<br>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</c:if>
	<hr>
	<c:if test="${pageContext.request.userPrincipal.name ==null }">
		<a href ="<c:url value ="/login" />">login</a>
	</c:if>
</body>
</html>