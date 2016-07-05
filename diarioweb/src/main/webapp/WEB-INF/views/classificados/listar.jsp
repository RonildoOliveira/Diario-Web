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

<link rel="stylesheet" href="../resources/responsive-tables.css">

<script src="../resources/responsive-tables.js"></script>

<title>Diário WEB - Listar Classificados</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>
	
	<div class="row">
		<div class="large-12 columns">
			<table class="responsive" width="100%">
				
			<c:forEach var="classificado" items="${classificados}">
			<tr>
			<td>
				<img height="100px" width="100px"
					src="/diarioweb/downloadcl/${classificado.classificadoId}.html">
				<a href="/diarioweb/classificados/exibir?id=${classificado.classificadoId}"> ${classificado.titulo}</a>
			</td>
			<td>				
				<p>${fn:substring(classificado.texto, 0, 80)}</p>
			</td>
				
			<td>
				<p>${classificado.preco}</p>
			</td>
			
			<c:if test="${usuario.getRegraId() == 2 ||
			usuario.getRegraId() == 3}">
			<td>
				<a href="/diarioweb/classificados?id=${classificado.classificadoId }"> 
					<img height="32px" width="32px" title="Remover" alt=""
					src="/diarioweb/resources/img/delete.png">
				</a>
			</td>
			</c:if>
			
			</tr>
			</c:forEach>
			</table>
			</div>
			</div>
		<div class="row">
		<div class="large-12 columns">
	<%@ include file="../rodape.jsp"%>
	</div>
	</div>
</body>
</html>