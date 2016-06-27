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

<title>Cadastrar Notícia</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">
		<form id="formNot" method="post" action="/diarioweb/noticias"
			enctype="multipart/form-data">
			<div class="large-6 columns">
				<div class="panel">
					<p>Título:</p>
					<input type="text" name="titulo" required />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Subtítulo:</p>
					<input type="text" name="subtitulo" required />
				</div>
			</div>

			<div class="large-12 columns">
				<div class="panel">
					<p>Texto:</p>
					<textarea rows="10" name="texto" required></textarea>
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Data da Noticia:</p>
					<input id="data" type="date" name="data" required />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Seção:</p>
					<select id="comboSecao" name="secaoId">
						<c:forEach var="secao" items="${secoes}">
							<option value="${secao.secaoId}">${secao.titulo}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="large-6 columns">
				Nome arqvuio: <input type="text" nome="nomeArquivo" />
			</div>
			<div class="large-6 columns">

				Escolha uma imagem: <input type="file" name="file" size="50" />

			</div>

			<div class="large-12 medium-12 columns">
				<div class="panel">
					<center>
						<input class="success button" id="cadNot" type="submit"
							value="Cadastrar Notícia" />
					</center>
				</div>
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