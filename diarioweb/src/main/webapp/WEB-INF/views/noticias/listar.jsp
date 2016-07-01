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

<title>Diário WEB - Todas as Notícias</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">
		
		

				<table class="responsive">
					<tr>
						<td><strong>ID:</strong></td>
						<td><strong>TÍTULO:</strong></td>
						<td><strong>TEXTO:</strong></td>
						<td><strong>PUBLICADO EM:</strong></td>
						<td><strong>IMAGEM:</strong></td>
						<td><strong><font color="red">CRUD:</font></strong></td>
					</tr>
					<c:forEach var="noticia" items="${noticias}">
						<tr>
							<td>${noticia.noticiaId}</td>
							<td><a href="/diarioweb/noticias/exibir?id=${noticia.noticiaId}">${fn:substring(noticia.titulo, 0, 50)}</a></td>
							<td>${fn:substring(noticia.texto, 0, 100)}</td>
							<td>${noticia.dataNoticia}</td>
							<td><img height="50px" width="50px"
								src="/diarioweb/download/${noticia.noticiaId}.html"></td>
							<!-- Editor pode apagar -->
							<c:if test="${usuario != null }">
        						<c:forEach var="regra" items="${usuario.regras }" >		
									<c:if test="${regra.nome == 'Editor'}">
					                  <c:if test="${usuario.getRegraId() == 2 }">	
										<td><a href="/diarioweb/noticias?id=${noticia.noticiaId }">
											<img height="16px" width="16px" alt=""
											src="/diarioweb/resources/img/delete.png">
										</a></td>
									  </c:if>                                             
					                </c:if>
					                <!-- Jornalista pode Editar  -->
					                <c:if test="${regra.nome == 'Jornalista'}">
					                  <c:if test="${usuario.getRegraId() == 3 }">	
										<td><a href="/diarioweb/noticias?id=${noticia.noticiaId }">
											<img height="16px" width="16px" alt=""
											src="/diarioweb/resources/img/delete.png">
										</a></td>
									  </c:if>                                             
					                </c:if>
					              </c:forEach>
         					 </c:if> 
							
							
						</tr>
					</c:forEach>
				</table>
         
			<%@ include file="../rodape.jsp"%>
		</div>

	</div>

</body>
</html>