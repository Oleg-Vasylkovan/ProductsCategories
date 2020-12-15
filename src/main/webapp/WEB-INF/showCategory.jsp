<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center m-5">${category.name}</h1>
	<div class="container d-flex justify-content-center">
		<div class="products m-2">
		<h3>Products:</h3>
			<ul>
				<c:forEach items="${products}" var="product">
					<li>${product.name}</li>
				</c:forEach>
			</ul>
		</div>
		<div class="form-group m-2">
			<form action="/categories" method="post">
				<label>Add Product</label>
				<select name="product">
					<c:forEach items="${products}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<input type="button" value="Add"/>
			</form>
		</div>
	
	</div>
</body>
</html>