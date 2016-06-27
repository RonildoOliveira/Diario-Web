<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link rel="stylesheet"
	href="../resources/css/rn.css">
	
<script
	src="../resources/js/modernizr.min.js"></script>

<title>Diário WEB - ${noticiaResult.titulo}</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>

	<div class="row">
	
	<div class="large-12 columns">
				
			<h3>${noticiaResult.titulo}</h3>
			<small>${noticiaResult.dataNoticia}</small>
			<div class="large-12w columns">
				<img class="imagemNoticia" src="/diarioweb/download/${noticiaResult.noticiaId}.html">
				<p class="textoNoticia">${noticiaResult.texto}</p>
			</div>

			<%@ include file="../comentarios/form.jsp"%>

			<h5>
				<strong>Comentários</strong>
			</h5>
			<c:forEach var="comentario" items="${comentarios}">
				<div class="panel">
					<p>${comentario.texto}</p>
				</div>
			</c:forEach>

			<div class="primary callout">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>
	<%@ include file="../footer.jsp"%>
	</div>

</body>
</html>