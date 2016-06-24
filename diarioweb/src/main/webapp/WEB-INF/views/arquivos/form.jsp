<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="pt-br">
<head>

<link rel="stylesheet"
	href="../resources/css/normalize.min.css">
<link rel="stylesheet"
	href="../resources/css/foundation.min.css">
<link
	href='../resources/css/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="../resources/js/modernizr.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<title>Upload de Arquivo</title>
</head>
<body>
	
	<%@ include file="../topo.jsp"%>
	
	<div class="row">

		<form method="post" action="/diarioweb/arquivos"
			enctype="multipart/form-data">
				Nome arqvuio:
				<input type="text" nome="nomeArquivo" />
						
				
				Escolha um Arquivo: <input type="file" name="file" size="50" />
			
			
				<p>
					<a href="/diarioweb/" class="button">Voltar</a>
					<input class="success button" type="submit" value="Upload" />
				</p>
			
		</form>
	</div>
</body>
</html>