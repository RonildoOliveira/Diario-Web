<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>
<link rel="stylesheet" href="../resources/responsive-tables.css">

<script src="../resources/responsive-tables.js"></script>
<script src="../resources/js/modernizr.min.js"></script>

<title></title>
</head>
<body>

	<div class="row">
		<div class="large-12 columns">
			
				<div class="large-12 columns">
			<h3>${secao.titulo}</h3>
			<h6>${secao.descricao}</h6>
			

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
		
		</div>

	</div>

</body>
</html>