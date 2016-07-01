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
			<small>Publicada em: ${noticiaResult.dataNoticia} por ${noticiaResult.autorNoticia.nome} </small>
			<div class="large-12w columns">
				<img class="imagemNoticia" src="/diarioweb/download/${noticiaResult.noticiaId}.html">
				<p class="textoNoticia">${noticiaResult.texto}</p>
			</div>
			
			<c:if test="${usuario != null }">
        	  <c:forEach var="regra" items="${usuario.regras }" >		
				<c:if test="${regra.nome == 'Leitor'}">
				   <c:if test="${usuario.getRegraId() == 1 }">  

						<%@ include file="../comentarios/form.jsp"%>
			
						<h5>
							<strong>Comentários</strong>
						</h5>
						<c:forEach var="comentario" items="${comentarios}">
							<div class="panel">
								<p>
								   <b>${comentario.autorComentario.nome }</b> <br/>
									${comentario.texto}
								</p>
							</div>
						</c:forEach>
					</c:if>
				</c:if>
			   </c:forEach>
			  </c:if>

			<%@ include file="../rodape.jsp"%>
		</div>

	</div>

</body>
</html>