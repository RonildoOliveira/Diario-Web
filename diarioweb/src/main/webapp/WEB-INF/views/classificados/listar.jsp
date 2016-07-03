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

<title>Diário WEB - Listar Classificados</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>
	
	
			<c:forEach var="classificado" items="${classificados}">
			<div class="row">
				<div class="large-6 columns">
					<img height="100px" width="100px"
							src="/diarioweb/downloadcl/${classificado.classificadoId}.html">
						<a href="/diarioweb/classificados/exibir?id=${classificado.classificadoId}"> ${classificado.titulo}</a>
				</div>
				
				<div class="large-4 columns">
					<p>${classificado.texto}</p>
				</div>
				
				<div class="large-2 columns">
					
					<p>${classificado.preco}</p>
					
				</div>
				</div>
			</c:forEach>
		
		<div class="row">
		<div class="large-12 columns">
	<%@ include file="../rodape.jsp"%>
	</div>
	</div>
</body>
</html>