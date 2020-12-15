<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center m-5">${product.name}</h1>
	<div class="container d-flex justify-content-center">
		<div class="categories m-2">
			<h3>Categories:</h3>
			<ul>
			<c:forEach items="${categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>	
			</ul>
		</div>
		<div class="addCategory m-2">
			<form action="/products" method="post">
				<label>Add Category</label>
				<select name="category">
				<c:forEach items="${categories}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
				</select>
				<input type="button" value="Add"/>	
			</form>
		</div>
	</div>
	
</body>
</html>