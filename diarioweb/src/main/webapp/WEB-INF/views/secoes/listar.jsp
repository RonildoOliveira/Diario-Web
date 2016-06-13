<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categorias</title>
</head>
<body>

	<table border="1">
		<c:forEach var="secao" items="${secoes}">
			<tr>
				<td>${secao.titulo}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="/diarioweb/">Voltar</a>

</body>
</html>