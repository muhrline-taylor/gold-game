<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/goldStyle1.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body>
	<h1>Ninja Gold Game</h1>
	<h4>Gold: <c:out value="${gold}"/></h4>
	<div class="center_box">
		<h3>Farm</h3>
		<p>Earns 10-20 gold</p>
		<form action="/farm" method="POST">
			<button type="submit">Get Gold</button>
		</form>
	</div>
	<div class="center_box">
		<h3>Cave</h3>
		<p>Earns 5-10 gold</p>
		<form action="/cave" method="POST">
			<button type="submit">Get Gold</button>
		</form>
	</div>
	<div class="center_box">
		<h3>House</h3>
		<p>Earns 2-5 gold</p>
		<form action="/house" method="POST">
			<button type="submit">Get Gold</button>
		</form>
	</div>
	<div class="center_box">
		<h3>Casino</h3>
		<p>Earns/takes 0-50 gold</p>
		<form action="/casino" method="POST">
			<button type="submit">Gamble</button>
		</form>
	</div>
	<h2>Activities</h2>
	<div class="faux_text_box">
		<c:forEach var = "i" begin = "0" end = "50">
        	<p><c:out value = "${messages[i]}"/></p>
        </c:forEach>
	</div>
</body>
</html>