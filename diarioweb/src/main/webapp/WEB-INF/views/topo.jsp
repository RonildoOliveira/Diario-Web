<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Diário Web</title>

<link href="resources/css/foundation.css" rel="stylesheet"	type="text/css" />

</head>
<body>
	<div class="row">
		<div class="large-12 columns">
			<h1>Diário WEB</h1>
			<h3>Slogan Legal</h3>
		</div>
	</div>

	<h3>Menu Bar</h3>
	<div>
		<c:forEach var="secao" items="${secoes}">
			<strong>${secao.titulo} |</strong>
		</c:forEach>
	</div>

</body>
</html>