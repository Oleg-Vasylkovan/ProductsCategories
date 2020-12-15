<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 	<h1 class="text-center m-5 ">New Product</h1>
 	<form:form action="/product" method="post" modelAttribute="product">
 		<div class="form-group m-5 w-35 mx-auto">
	 		<div class="m-2">
	 			<form:label path="name">Name: </form:label>
	 			<form:input path="name" class="form-control"/>
	 		</div>
	 		<div class="m-2">
	 			<form:label path="description">Description: </form:label>
	 			<form:input path="description" class="form-control"/>
	 		</div>
	 		<div class="m-2">
	 			<form:label path="price">Price: </form:label>
	 			<form:input path="price" class="form-control"/>
	 		</div>
	 		<div class="m=3">
	 			<input type="submit" value="Create"/>
	 		</div>
 		</div>
 	</form:form>
</body>
</html>