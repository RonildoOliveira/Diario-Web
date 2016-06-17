<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/css/foundation.css" rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="large-12 columns">


		<div class="large-12 medium-12 columns">

			<table border="2">
				<tr>
					<td><strong>Id</strong></td>
					<td><strong>Título</strong></td>
					<td><strong>Texto</strong></td>
					<td><strong>Publicado em:</strong></td>
				</tr>
				<c:forEach var="noticia" items="${noticias}">
					
						<td>${noticia.noticiaId}</td>
						<td>${noticia.titulo}</td>
						<td>${noticia.texto}</td>
						<td>${noticia.dataNoticia}</td>
					
					<tr>
						
					</tr>
				</c:forEach>
			</table>
			
			<div class="primary callout">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>


	</div>

</body>
</html>