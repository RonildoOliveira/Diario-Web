<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>

<script src="../resources/js/rn.js" charset="utf-8"></script>
<title>Diário WEB - Cadastro de Jornalista</title>
</head>
<body>
	<div class="row">
		<div class="large-3 columns">
			<!--  topo  logo-->
			 
			<img
				src="/diarioweb/resources/img/dweb_logo.png" />
			
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
	

	<div class="row">
		<form method="post" action="/diarioweb/usuarios/formulario_jornalista" 	enctype="multipart/form-data">

			<div class="large-6 columns">
				<div class="panel">
					<p>Nome:</p>
					<input type="text" name="nome" required>
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Login:</p>
					<input type="text" name="login" required>
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>E-Mail:</p>
					<input type="text" name="email" required>
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Senha:</p>
					<input type="password" name="senha" required>
				</div>
			</div>
			
			<div class="large-6 columns">

				Selecione uma foto: <input type="file" name="file" size="50" required/>

			</div>

			<div class="large-12 columns">
				<div class="panel">
					<center>
						<input class="success button" type="submit" value="Cadastrar" />
					</center>
					<%@ include file="../rodape.jsp"%>
				</div>				
			</div>
			
		</form>
		
	</div>
</body>
</html>
