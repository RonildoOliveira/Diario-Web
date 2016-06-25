<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios - FORM</title>
</head>
<body>
	<form method="post" action="/diarioweb/usuarios">
		<strong>Usuario:</strong>
		Nome:<input type="text" name="nome">
		Login:<input type="text" name="login">
		E-Mail:<input type="text" name="email">
		Senha:<input type="password" name="senha">
		
		<input class="success button" type="submit" value="Cadastrar" />
	</form>

</body>
</html>
