<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>
<title>Cadastrar Seções</title>
</head>
<body>
	<%@ include file="../topo.jsp"%>
	<div class="row">
		<form method="post" action="/diarioweb/secoes">
			<div class="large-6 columns">
				<div class="panel">
					<p>Nome da Seção:</p>
					<input type="text" name="titulo" />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Descrição da Seção:</p>
					 <input type="text" name="descricao" />
				</div>
			</div>
			
			<div class="large-12 columns">
			<center>
			<input class="success button" type="submit" value="Cadastrar" />
			</center>
			</div>
			

		</form>
		<div class="large-12 medium-12 columns">
			<p>
				<a href="/diarioweb/" class="button">Voltar</a>
			</p>
		</div>
	</div>
</body>
</html>