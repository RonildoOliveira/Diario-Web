<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="../resources/css/normalize.min.css">
<link rel="stylesheet"
	href="../resources/css/foundation.min.css">
<link
	href='../resources/css/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="../resources/js/modernizr.min.js"></script>

<title>Diário WEB - Notícias Por Seção</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>
	<div class="row">
		
		<div class="large-12 columns">
			<h3>${secao.titulo}</h3>
			<h6>${secao.descricao}</h6>
			
			<c:if test="${fn:length(noticias) le 0}">
				<%@ include file="../404.jsp"%>
			</c:if>
		</div>
			
			<c:forEach var="noticia" items="${noticias}">
			<div class="large-4 columns">
			<img src="/diarioweb/download/${noticia.noticiaId}.html">
			</div>
			
			<div class="large-8 columns">
				<div class="panel">
				<strong>
				<a href="/diarioweb/noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a>
				</strong>
				<br>		
					<small>${noticia.dataNoticia}</small>
					<p>${fn:substring(noticia.texto, 0, 100)}...<a href="/diarioweb/noticias/exibir?id=${noticia.noticiaId}">Leia Mais</a></p>
				</div>
			</div>
			
			</c:forEach>
	
			<div class="large-12 columns">
			<%@ include file="../rodape.jsp"%>
			</div>
		
	</div>
</body>
</html>