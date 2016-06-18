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
			<div class="row">
				<h3>${secao.titulo}</h3>
				<h6>${secao.descricao}</h6>		
				<c:forEach var="noticia" items="${noticias}">
					<div class="primary callout">
						<h3><a href="/diarioweb/noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a></h3>
						<h6>${noticia.dataNoticia}</h6>
						<p>${noticia.texto}</p>
					</div>
				</c:forEach>

				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
				
			</div>
		</div>
	</div>
</body>
</html>