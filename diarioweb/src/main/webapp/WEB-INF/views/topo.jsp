<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Diário Web</title>

<link href="resources/css/foundation.css" rel="stylesheet"
	type="text/css" />

</head>
<body>

	<div class="large-12 columns">
		<div class="row">
			<h1>Diário WEB</h1>
			<h3><i>Slogan Legal</i></h3>
		</div>
		
		
		<div class="row">
			<ul class="vertical medium-horizontal menu">
				<li><a href="/diarioweb/" title="Volte à página inicial">Início</a></li>
				<c:forEach var="secao" items="${secoes}">
					<li><a href="/diarioweb/noticias/listarsec?id=${secao.secaoId}" title="${secao.descricao}">${secao.titulo}</a></li>
				</c:forEach>
				<!-- 				<li><input type="search" placeholder="Buscar"></li> -->
				<!-- 				<li><button type="button" class="button">Buscar</button></li> -->
			</ul>
		</div>

	</div>


</body>
</html>