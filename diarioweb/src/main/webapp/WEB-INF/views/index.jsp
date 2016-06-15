<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Diário Web</title>

<link href="resources/css/main.css" rel="stylesheet" type="text/css" />  
   
</head>
<body>

 <div class="topo">
 	<img alt="" src="resources/img/icon.png">
 	<h1>Diário WEB</h1> <h3>Slogan Legal</h3>
 </div>

<h3>Menu Bar</h3> 
 <div class="menu">
		<c:forEach var="secao" items="${secoes}">
				<strong>${secao.titulo} |</strong>
		</c:forEach>
 </div>
 
<h3>Noticias Recentes</h3> 
 <div class="recentes">
 	<ul>
		<c:forEach var="noticia" items="${noticiasRecentes}">
			<li>
				${noticia.titulo}
				<img alt="" src="${noticia.nomeImagem}">
			</li>
		</c:forEach>
	</ul>
 </div>
 
<h2>Notícias</h2>
<a href="noticias/form">Cadastrar Notícia</a>
<br>

<a href="noticias/listar">Listar Notícias</a>
<br>

<h2>Comentátios</h2>
<a href="comentarios/form">Cadastrar Comentário</a>
<br>
<a href="comentarios/listar">Listar Comentários</a>
<br>

<h2>Secoes</h2>
<a href="secoes/form">Cadastrar Secão</a>
<br>

<a href="secoes/listar">Listar Secões</a>
<br>

 <div class="footer">
 	Desenvolvido Por: HUEBR
 </div>
 
</body>
</html>