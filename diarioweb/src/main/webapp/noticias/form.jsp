<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/diarioweb/noticias">
		<div>
			<label for="title">Titulo</label> <input type="text" name="titulo"
				id="titulo" />
		</div>
		
		<div>
			<label for="description">Descrição</label>
			<br>
			<textarea rows="10" cols="24" name="descricao" id="descricao">
			</textarea>
		</div>
		<br>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form>
</body>
</html>