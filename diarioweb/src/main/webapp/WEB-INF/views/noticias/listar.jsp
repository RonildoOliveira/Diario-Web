<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>

<title>Diário WEB - Todas as Notícias</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">

			<table border="2">
				<tr>
					<td><strong>ID:</strong></td>
					<td><strong>TÍTULO:</strong></td>
					<td><strong>TEXTO:</strong></td>
					<td><strong>PUBLICADO EM:</strong></td>
					<td><strong>IMAGEM:</strong></td>
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
					</tr>
				</c:forEach>
			</table>

			<div class="panel">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>

	</div>

</body>
</html>