<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		LOGIN
		</head>
		<body>
			<!-- for normal-->
			<!-- welcome to spring boot--> 
			<!-- for single list values-->
			<!--<h1>  ${msg} Welcome to Spring boot </h1>-->
			<!-- for iteration-->
			<form action=""></form>
			<c:forEach var="name" items="${msg}">
				<h1> ${name} Welcome to Spring Boot </h1>
				</c:forEach>
			</body>
			</html>