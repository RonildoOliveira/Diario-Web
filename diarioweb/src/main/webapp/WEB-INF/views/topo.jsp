<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="resources/css/normalize.min.css">
<link rel="stylesheet" href="resources/css/foundation.min.css">
<link href='resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="resources/js/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>
	<div class="row">
		<div class="large-3 columns">
			<!--  topo  logo-->
			 
			<img
				src="/diarioweb/resources/img/dweb_logo.png" />
			
		</div>

		<div class="large-9 columns">
			
				<c:if test="${usuario == null }">
				<ul class="right button-group">
					<li><a href="/diarioweb/usuarios/login" class="button">Login</a></li>
					<li><a href="/diarioweb/usuarios/form" class="success button">Cadastrar-se</a></li>
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
</body>
</html>