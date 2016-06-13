<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seções</title>
</head>
<body>
	<form method="post" action="/diarioweb/comentarios">
		<table>
			<tr>
				<td>Texto:</td>
				<td><input type="text" name="texto" /></td>
			</tr>

			<tr>
				<td><select name="noticiaId">
						<c:forEach var="noticia" items="${noticias}">
							<option value="${noticia.noticiaId}">${noticia.titulo}</option>
						</c:forEach>
				</select> Seção:</td>
			</tr>


			<tr>
				<td><input type="submit" value="Cadastrar" /></td>
			</tr>

		</table>
	</form>

</body>
</html>