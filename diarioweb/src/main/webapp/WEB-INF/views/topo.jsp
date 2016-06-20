<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="resources/css/normalize.min.css">
<link rel="stylesheet"
	href="resources/css/foundation.min.css">
<link
	href='resources/css/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="resources/js/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>
	<div class="row">
		<div class="large-3 columns">
			<!--  topo  logo-->
			<h2><a href="/diarioweb/">Diário WEB</a></h2>
			<!-- <img src="http://placehold.it/400x100&text=Logo"/> -->
		</div>

		<div class="large-9 columns">
			<ul class="right button-group">
				<li><a href="/diarioweb/usuarios/login" class="button">Login</a></li>
			</ul>
		</div>
		<!--  topo  logo-->


		<div class="large-12 columns">
			<!--  menu bar -->

			<nav class="top-bar" data-topbar>
			<ul class="title-area">

				<li class="name">
					<h1>
						<a href="/diarioweb/">Home</a>
					</h1>
				</li>

				<li class="toggle-topbar menu-icon"><a href="#"><span>menu</span></a>
				</li>
			</ul>

			<section class="top-bar-section">
			<ul class="left">
				<c:forEach var="secao" items="${secoes}">
					<li>
					<a href="/diarioweb/noticias/listarsec?id=${secao.secaoId}"
						title="${secao.descricao}"> ${secao.titulo}
					</a>
					</li>
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
			</section> </nav>
		</div>
		<!-- large-12 columns menu bar -->
	</div><!-- row  -->
</body>
</html>