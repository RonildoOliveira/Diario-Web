<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>
<title>�rea do Administrador</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>
	<div class="row">

		<div class="large-6 columns">
			<div class="panel">
				<h3>Not�cias</h3>
				<ul>
					<li><a href="/diarioweb/noticias/listar">Listar Todas as
							Not�cias</a></li>
					<li><a href="/diarioweb/noticias/form">Cadastrar Not�cias</a></li>
				</ul>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3>Se��es</h3>
				<ul>
					<li><a href="/diarioweb/secoes/listar">Listar Todas as
							Se��es</a></li>
					<li><a href="/diarioweb/secoes/form">Cadastrar Se��es</a></li>
				</ul>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3>Usu�rios</h3>
				<ul>
					<li><a href="/diarioweb/usuarios/listar">Listar Todas os
							Usu�rios</a></li>
					<li><a href="/diarioweb/usuarios/form">Cadastrar Usu�rios</a></li>
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