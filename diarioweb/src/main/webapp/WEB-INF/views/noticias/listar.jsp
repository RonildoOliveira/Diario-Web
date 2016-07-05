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

<title>Di�rio WEB - Todas as Not�cias</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			
			<c:if test="${usuario.getRegraId() == 2 ||
			usuario.getRegraId() == 3}">
			
			<table class="responsive" width="100%">
				<tr>
					<td><strong>ID:</strong></td>
					<td><strong>T�TULO:</strong></td>
					<td><strong>TEXTO:</strong></td>
					<td><strong>PUBLICADO EM:</strong></td>
					<td><strong>IMAGEM:</strong></td>
					<td><strong>JORNALISTA:</strong></td>
					<td><strong><font color="red">REMOVER:</font></strong></td>
				</tr>
				<c:forEach var="noticia" items="${noticias}">
					<tr>
						<td>${noticia.noticiaId}</td>
						<td><a
							href="/diarioweb/noticias/exibir?id=${noticia.noticiaId}">${fn:substring(noticia.titulo, 0, 50)}</a></td>
						<td>${fn:substring(noticia.texto, 0, 100)}</td>
						<td>${noticia.dataNoticia}</td>
						<td><img height="50px" width="50px"
							src="/diarioweb/download/${noticia.noticiaId}.html"></td>
						<td><img title="${usuario.id}" class="imagemNoticia" height="32px" width="32px"
								src="/diarioweb/profile/${noticia.autorNoticia.id}.html">
						</td>
						<td><a
							href="/diarioweb/noticias?id=${noticia.noticiaId }"> 
							<img height="16px" width="16px" title="Remover" alt=""
							src="/diarioweb/resources/img/delete.png">
							</a>					
						</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${usuario.getRegraId() == 1 || usuario == null}">
			
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
		</c:if>
		
			<%@ include file="../rodape.jsp"%>
		</div>

	</div>

</body>
</html>