<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product List</h1> 
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
		</tr>
		
		<c:forEach items="${products}" var="p">
			<tr>
				<td> ${p.id} </td>
				<td> ${p.name} </td>
				<td> ${p.price} </td>
				<td> ${p.category} </td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="index.html">Back</a>
</body>
</html>