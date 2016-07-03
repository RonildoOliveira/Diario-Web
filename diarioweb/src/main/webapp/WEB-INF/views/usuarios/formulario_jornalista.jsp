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
	<%@ include file="../topo.jsp"%>

	<div class="row">
		<form method="post" action="/diarioweb/usuarios/formulario_jornalista" onsubmit="formJornalista()"
		enctype="multipart/form-data">

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
