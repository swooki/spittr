<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css"/>">
</head>
<body>
	<h1>Home</h1>
	<a href="<c:url value="/spittles" />">Spittles</a> |
	<a href="<c:url value="/spitter/register"/>">Register</a> |
	<a href="<c:url value="/Sung"/>">Sung</a>
</body>
</html>