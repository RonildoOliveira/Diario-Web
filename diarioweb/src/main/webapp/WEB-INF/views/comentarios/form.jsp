<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<form method="post" action="/diarioweb/comentarios">
		<strong>Comentário:</strong>
		<textarea rows="4" name="texto" required></textarea>
		<input type="hidden" name="noticiaId" value="${noticia.noticiaId}">
		<input class="success button" type="submit" value="Comentar" />
	</form>

</body>
</html>