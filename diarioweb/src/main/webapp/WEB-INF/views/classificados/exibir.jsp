<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

<title>Diário WEB - ${classificadoResult.titulo }</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">

			<table class="responsive" width="100%">
				<tr>
					<td>
					<img height="200px" width="200px"
							src="/diarioweb/downloadcl/${classificadoResult.classificadoId}.html">
					</td>
					<td></td>
				</tr>
				<tr>
					<td><strong>Título:</strong></td>
					<td>${classificadoResult.titulo }</td>
				</tr>
				<tr>
					<td><strong>Descrição:</strong></td>
					<td><p>${classificadoResult.texto }</p></td>
				</tr>
				<tr>
					<td><strong>Preço:</strong></td>
					<td>${classificadoResult.preco }</td>
				</tr>
				<tr>
					<td><strong>Telefone:</strong></td>
					<td>${classificadoResult.telefone }</td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td><strong>Oferta:</strong></td> -->
<%-- 					<td>${classificadoResult.melhor_oferta }</td> --%>
<!-- 				</tr> -->
				<tr>
					<td><strong>Data:</strong></td>
					<td>${classificadoResult.data_oferta }</td>
				</tr>

				<c:if test="${not empty classificadoResult.autorOferta }">
					<tr>
						<td><strong>Ofertado por:</strong></td>
						<td>${classificadoResult.autorOferta.nome }</td>
					</tr>
				</c:if>

				<c:forEach var="regra" items="${usuario.regras}">
					<c:if test="${regra.nome == 'Leitor' }">
						<c:if test="${usuario.getRegraId() == 1 }">
							<tr>
								<td></td>
								<td><%@ include file="../classificados/ofertar.jsp"%>
								</td>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</table>



			<%@ include file="../rodape.jsp"%>
		</div>

	</div>

</body>
</html>