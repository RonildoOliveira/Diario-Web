<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/css/normalize.min.css">
<link rel="stylesheet" href="resources/css/foundation.min.css">
<link href='resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="resources/js/modernizr.min.js"></script>

<title></title>
</head>
<body>
		<c:if test="${usuario == null }">
		 
		 
			<div class="panel">
				<p><a href="/diarioweb/" class="button">Voltar</a></p>
			</div>
			
		</c:if>
		<c:if test="${usuario != null }">
		  <c:forEach var="regra" items="${usuario.regras }" >
			<c:if test="${regra.nome == 'Leitor' }">
				<div class="panel">
					<p><a href="/diarioweb/" class="button">Voltar</a></p>					
				</div>						
			</c:if>
			<c:if test="${regra.nome == 'Editor' }">
				<div class="panel">
					<p><a href="/diarioweb/usuarios/homeadmin" class="button">Voltar</a></p>
				</div>					
			</c:if>
			<c:if test="${regra.nome == 'Jornalista' }">
				<div class="panel">
					<p><a href="/diarioweb/usuarios/homeadmin" class="button">Voltar</a></p>
				</div>					
			</c:if>
		  </c:forEach>
		</c:if>

</body>
</html>