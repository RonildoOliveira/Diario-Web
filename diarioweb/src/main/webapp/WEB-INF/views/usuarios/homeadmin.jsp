<%@page import="ufc.web.diario.models.TipoUsuario"%>
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
<title> Administrador</title>
</head>
<body>
	<c:if test="${usuario == null }">
		<%@ include file="../404.jsp"%>
	</c:if>
	<c:if test="${usuario != null }">
		<%@ include file="../topo.jsp"%>
	</c:if>
	

		
	<div class="row">
		
	
		<c:if test="${usuario != null }">
		<!--  Renderizar o tamanho da Imagem. -->
		
		<div class="large-12 columns">
			<!--  12 columns -->
			<c:choose>
				<c:when test="${fn:length(noticiasRecentes) le 0}">
					<%@ include file="../404.jsp"%>
				</c:when>

				<c:otherwise>
					<ul class="example-orbit" data-orbit>
						<!-- Slider -->

						<c:forEach begin="0" end="4" var="noticia"
							items="${noticiasRecentes}">
							<li><img height="400px" width="1000px"
								src="/diarioweb/download/${noticia.noticiaId}.html" /> <a
								href="noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a>
							</li>
						</c:forEach>
					</ul>
				</c:otherwise>

			</c:choose>
			<hr />
	</div>
		<!--  12 columns -->


        	<c:forEach var="regra" items="${usuario.regras }" >		

                <c:if test="${regra.nome == 'Editor'}">
                  <c:if test="${usuario.getRegraId() == 2 }">	

						<!-- Menu Editor -->
						<div class="large-12 columns">
							<div class="panel">
								<h3>Notícia</h3>
								<ul>
									<li><a href="/diarioweb/noticias/listar">Listar Notícias</a></li>
									<li><a href="/diarioweb/usuarios/formulario_jornalista">Cadastrar Jornalista</a></li>
								</ul>
							</div>
						</div>
						
						<div class="large-12 columns">
							<div class="panel">
								<h3>Seção</h3>
								<ul>
									<li><a href="/diarioweb/secoes/listar">Listar Seções</a></li>		
									<li><a href="/diarioweb/secoes/form">Cadastrar Seção</a></li>
								</ul>
							</div>
						</div>
						
						<div class="large-12 columns">
							<div class="panel">
								<h3>Classificado</h3>
								<ul>
									<li><a href="/diarioweb/classificados/listar">Listar Classificados</a></li>
									<li><a href="/diarioweb/classificados/form">Cadastrar Classificado</a></li>
								</ul>
							</div>
						</div>
						
						<div class="large-12 columns">
							<div class="panel">
								<h3>Usuários</h3>
								<ul>
									<li><a href="/diarioweb/usuarios/listar">Listar Usuários</a></li>
								</ul>
							</div>
						</div>										
		   
				  </c:if>                                             
                </c:if>
             

               <!-- Funcionalidades que o Jornalista pode realizar. -->             
                <c:if test="${regra.nome == 'Jornalista'}">
                   <c:if test="${usuario.getRegraId() == 3 }">

							<div class="large-12 columns">
								<div class="panel">
									<h3>Notícia</h3>
									<ul>
									<li><a href="/diarioweb/noticias/listar">Listar Notícias</a></li>
									<li><a href="/diarioweb/noticias/form">Cadastrar Notícias</a></li>	
									</ul>
								</div>
							</div>
							
							<div class="large-12 columns">
								<div class="panel">
									<h3>Seção</h3>
									<ul> <li><a href="/diarioweb/secoes/listar">Listar Seções</a></li> </ul>
								</div>
							</div>
							
							<div class="large-12 columns">
							<div class="panel">
								<h3>Classificado</h3>
								<ul>
									<li><a href="/diarioweb/classificados/listar">Listar Classificados</a></li>
								</ul>
							</div>
						</div>		
									

                   </c:if>
                </c:if>
            </c:forEach>
         </c:if>   

</div>	
		
	<script src="../resources/js/jquery-2.1.4.min.js"></script>
	<script src="../resources/js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>
	
</body>
</html>