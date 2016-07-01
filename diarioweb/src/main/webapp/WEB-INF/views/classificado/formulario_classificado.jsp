<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../resources/css/normalize.min.css">
<link rel="stylesheet" href="../resources/css/foundation.min.css">
<link href='../resources/css/foundation-icons.css' rel='stylesheet'
	type='text/css'>

<script src="../resources/js/modernizr.min.js"></script>
<script src="../resources/js/rn.js" charset="utf-8"></script>

<title>Cadastrar Classificado</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<form id="formNot" method="post" action="adicionarClassificado"
			enctype="multipart/form-data">
			<div class="large-6 columns">
				<div class="panel">
					<p>Título:</p>
					<input type="text" name="titulo" required />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Texto:</p>
					<textarea rows="4" name="texto" required></textarea>
				</div>
			</div>
			
			<div class="large-6 columns">
				<div class="panel">
					<p>Preço Inicial:</p>
					<input type="text" name="preco" required />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Telefone:</p>
					<input type="text" name="telefone" required />
				</div>
			</div>

			<div class="large-12 medium-12 columns">
				<div class="panel">
						<input class="success button" id="cadNot" type="submit"
							value="Cadastrar Classificado" />
				</div>
				<%@ include file="../rodape.jsp"%>
			</div>
		</form>
	</div>

</body>
</html>