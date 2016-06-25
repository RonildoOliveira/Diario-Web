<%@page import="ufc.web.diario.models.TipoUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="resources/css/normalize.min.css">
<link rel="stylesheet" href="resources/css/foundation.min.css">
<link href='resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="resources/js/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>

	<%@ include file="topo.jsp"%>

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
						<c:forEach var="noticia" items="${noticiasRecentes}">
							<li><img src="resources/img/news.png"> <a
								href="noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a>
							</li>
						</c:forEach>
					</ul>
				</c:otherwise>
				
			</c:choose>
			<hr />
		</div>
		<!--  12 columns -->

		<div class="large-12 columns">
			<!-- 			-----------------------------------------------------           -->
			<h2>Usuarios</h2>

			<a href="/diarioweb/usuarios/form">Upload</a> <a
				href="/diarioweb/usuarios/listar">Listar</a>
				
			<h2>Arvuios</h2>

			<a href="/diarioweb/arquivos/form">Upload</a> <a
				href="/diarioweb/arquivos/listar">Listar</a>

			<h2>Notícias</h2>

			<a href="/diarioweb/noticias/form">Cadastrar Notícia</a> <br> <a
				href="/diarioweb/noticias/listar">Listar Notícias</a> <br>

			<h2>Secoes</h2>
			<a href="/diarioweb/secoes/form">Cadastrar Secão</a> <br>

			<h2>User</h2>
			<a href="/diarioweb/usuarios/login">Login</a> <br>

			<%
				pageContext.setAttribute("monEnum", TipoUsuario.values());
			%>
			<c:forEach var="entry" items="${monEnum}">
				<option>${entry.nomeTipoUsuario}</option>
			</c:forEach>
			<!-- 			-----------------------------------------------------           -->
		</div>
	</div>
	<!-- ROWS -->

	<script src="resources/js/jquery-2.1.4.min.js"></script>
	<script src="resources/js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>

</body>
</html>