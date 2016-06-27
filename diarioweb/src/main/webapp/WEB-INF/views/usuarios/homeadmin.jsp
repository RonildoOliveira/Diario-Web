<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>
<title>Área do Administrador</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>
	<div class="row">

		<div class="large-6 columns">
			<div class="panel">
				<h3>Notícias</h3>
				<ul>
					<li><a href="/diarioweb/noticias/listar">Listar Todas as
							Notícias</a></li>
					<li><a href="/diarioweb/noticias/form">Cadastrar Notícias</a></li>
				</ul>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3>Seções</h3>
				<ul>
					<li><a href="/diarioweb/secoes/listar">Listar Todas as
							Seções</a></li>
					<li><a href="/diarioweb/secoes/form">Cadastrar Seções</a></li>
				</ul>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3>Usuários</h3>
				<ul>
					<li><a href="/diarioweb/usuarios/listar">Listar Todas os
							Usuários</a></li>
					<li><a href="/diarioweb/usuarios/form">Cadastrar Usuários</a></li>
				</ul>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3></h3>

			</div>
		</div>
		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>