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
			
			<c:forEach var="classificado" items="${classificados}">
				<div class="panel">
					<table>
						<tr>  
							<td> <a href="exibirClassificado?id=${classificado.classificadoId}"> ${classificado.titulo }</a> </td>
						</tr>
					</table>
				</div>
			</c:forEach>
			<%@ include file="../rodape.jsp"%>
		</div>
	</div>
	
</body>
</html>