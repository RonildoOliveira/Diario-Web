<%@page import="ufc.web.diario.models.TipoUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/css/normalize.min.css">
<link rel="stylesheet" href="resources/css/foundation.min.css">
<link href='resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<link rel="stylesheet" href="resources/css/rn.css">

<script src="resources/js/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>

	<!-- Topo -->
	<div class="row">
		<div class="large-3 columns">
			<!--  topo  logo-->
			 
			<img
				src="/diarioweb/resources/img/dweb_logo.png" />
			
		</div>

		<div class="large-9 columns">
			
				<c:if test="${usuario == null }">
				<ul class="right button-group">
					<li><a href="usuarios/login" class="button">Login</a></li>
					<li><a href="usuarios/form" class="success button">Cadastrar-se</a></li>
				</ul>
				</c:if>
				<c:if test="${usuario != null }">
					
						<ul class="right button-group">
							<li>Bem-Vindo(a) ${usuario.login}</li>
							<li><img height="49px" width="49px"
								src="/diarioweb/profile/${usuario.id}.html"></li>
							<li><a href="/diarioweb/usuarios/sair" class="button">Sair</a></li>
						</ul>
					
				</c:if>
		</div>
		<!--  topo  logo-->


		<div class="large-12 columns">
			<!--  menu bar -->

			<nav class="top-bar" data-topbar>
				<ul class="title-area">

					<li class="name">
						<h1>
							<a href="/diarioweb/" title="Inicio">Home</a>
						</h1>
					</li>

					<li class="toggle-topbar menu-icon"><a href="#"><span>menu</span></a>
					</li>
				</ul>

				<section class="top-bar-section">
					<ul class="left">
						<c:forEach var="secao" items="${secoes}">
							<li><a
								href="/diarioweb/noticias/listarsec?id=${secao.secaoId}"
								title="${secao.descricao}"> ${secao.titulo} </a></li>
						</c:forEach>
					</ul>

					<ul class="right">
						<li class="search">
							<form>
								<input type="search">
							</form>
						</li>

						<li class="has-button"><a class="small button" href="#">Search</a>
						</li>
					</ul>
				</section>
			</nav>
		</div>
		<!-- large-12 columns menu bar -->
	</div>
	<!-- row  -->

	<!-- 	https://developers.facebook.com/docs/plugins/page-plugin -->
	<!-- 	https://twitter.com/settings/widgets/592398058639499266/edit?notice=WIDGET_UPDATED -->

	<div class="row">
		<div class="large-12 columns">
			<!--  12 columns -->
			<c:choose>
				<c:when test="${fn:length(noticiasRecentes) le 0}">
					<%@ include file="404.jsp"%>
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
		
		<!-- Visualização de Classificados -->
         <div class="large-6 columns">
			<div class="panel">
				<a href="classificados/listar">CLASSIFICADOS</a> 
			</div>
	 	 </div>
	 	 <div class="large-6 columns">
			<div class="panel">
				<ul> <li><a href="noticias/listar">Visualizar Noticias</a></li> </ul> 
			</div>
	 	 </div>	
	
	<%@ include file="footer.jsp"%>
	
	</div>
		<!--  12 columns -->
		
		
	</div>
	<!-- ROWS -->
	
	
	
	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>

</body>
</html>