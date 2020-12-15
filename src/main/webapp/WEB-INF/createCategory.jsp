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
	<h1 class="text-center">New Category</h1>
	<form:form action="/category" method="post" modelAttribute="category">
		<div class="form-group m-5 w-35 mx-auto">
			<div>
				<form:label path="name">Name</form:label>
				<form:input path="name" class="form-control"/>
			</div>
			<div>
				<input type="submit" value="Create"/>
			</div>
		</div>
	</form:form>

</body>
</html>