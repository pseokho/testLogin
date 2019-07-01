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
   <div class="container centered text-center">
        <form class="form-signin" method="POST" th:action="@{/login}">
            <h1 class="h3 mb-3 font-weight-normal">[[${login_message}]]</h1>
            <label for="username" class="sr-only">ID</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="ID" required="" autofocus="">
            <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
            <div class="checkbox mb-3">
                <label><input type="checkbox" value="remember-me"> Remember me</label>
            </div>
            <div align="center" th:if="${param.error}">
                <p style="font-size: 20; color: #FF1C19;">ID or Password invalid, please verify</p>
            </div>
            <button class="btn btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
    
</body>
</html>