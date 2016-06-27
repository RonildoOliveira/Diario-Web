<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>
<script src="../resources/responsive-tables.js"></script>

<title>Listar todas as seções</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">

			<table class="responsive">
				<tr>
					<td><strong>ID:</strong></td>
					<td><strong>TÍTULO:</strong></td>
					<td><strong>DESCRIÇÃO:</strong></td>
					<td><strong><font color="red">CRUD:</font></strong></td>
				</tr>
				<c:forEach var="secao" items="${secoes}">
					<tr>
						<td>${secao.secaoId}</td>
						<td><a
							href="/diarioweb/noticias/listarsec?id=${secao.secaoId}">${fn:substring(secao.titulo, 0, 50)}</a></td>
						<td>${fn:substring(secao.descricao, 0, 100)}</td>
						<td><a href="/diarioweb/secoes?id=${secao.secaoId }"> <img
								height="16px" width="16px" alt=""
								src="/diarioweb/resources/img/delete.png">
						</a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="panel">
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
				</p>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>