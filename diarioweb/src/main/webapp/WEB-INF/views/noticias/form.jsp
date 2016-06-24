<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="../resources/css/normalize.min.css">
<link rel="stylesheet"
	href="../resources/css/foundation.min.css">
<link
	href='../resources/css/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="../resources/js/modernizr.min.js"></script>
	
<title>Cadastrar Notícia</title>
</head>
<body>

	<%@ include file="../topo.jsp"%>

	<div class="row">

		<form method="post" action="/diarioweb/noticias">
			<div class="large-6 columns">
				<div class="panel">
					<p>Título:</p>
					<input type="text" name="titulo" />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Subtítulo:</p>
					<input type="text" name="subtitulo" />
				</div>
			</div>

			<div class="large-12 columns">
				<div class="panel">
					<p>Texto:</p>
					<textarea placeholder="Texto da Notícia" name="texto"></textarea>
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Data da Noticia:</p>
					<input id="data" type="date" name="data" />
				</div>
			</div>

			<div class="large-6 columns">
				<div class="panel">
					<p>Seção:</p>
					<select name="secaoId">
						<c:forEach var="secao" items="${secoes}">
							<option value="${secao.secaoId}">${secao.titulo}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="large-12 medium-12 columns">
				<div class="panel">
					<p>
						<a href="/diarioweb/" class="button">Voltar</a> <input
							class="success button" id="cadNot" type="submit"
							value="Cadastrar Notícia" />
					</p>
				</div>
			</div>
		</form>
	</div>

</body>
</html>